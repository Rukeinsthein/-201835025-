package com.example.a201835025;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {
    private TextView questions;
    private TextView question;

    private AppCompatButton option1, option2, option3, option4;

    private AppCompatButton nextButton;

    private Timer quizTimer;

    private int totalTimeInMins = 1;

    private int seconds = 0;

    private List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;

    private String selectedOptionByUser = "";

    private MediaPlayer mediaPlayer;

    int[] musics;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backBtn = findViewById(R.id.backBtn);
        final TextView timer = findViewById(R.id.timer);
        final TextView selectedTopicName = findViewById(R.id.topicName);

        questions = findViewById(R.id.questions);
        question = findViewById(R.id.question);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        nextButton = findViewById(R.id.nextButton);

        final String getSelectedTopicName = getIntent().getStringExtra("selectedTopic");

        selectedTopicName.setText(getSelectedTopicName);

        questionsLists = QuestionLibrary.getQuestions(getSelectedTopicName);


        startTimer(timer);

        questions.setText((currentQuestionPosition + 1) + "/" + questionsLists.size());

        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getOption1());
        option2.setText(questionsLists.get(0).getOption2());
        option3.setText(questionsLists.get(0).getOption3());
        option4.setText(questionsLists.get(0).getOption4());

        /*
        String mpName = questionsLists.get(currentQuestionPosition).getAnswer().toLowerCase();
        Resources res = getResources();
        int soundId = res.getIdentifier(mpName, "raw", getPackageName());
        MediaPlayer mp = MediaPlayer.create(this, soundId);
        if (soundId!=0){
            mp.start();
        }

         */

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        if (getSelectedTopicName.equals("song")) {
            musics = new int[]{R.raw.guitar, R.raw.piano, R.raw.violin, R.raw.saxophone, R.raw.clairnet,
                    R.raw.drum, R.raw.oud, R.raw.electroguitar, R.raw.flute, R.raw.tambourine};
        } else if (getSelectedTopicName.equals("instr")) {
            musics = new int[]{R.raw.akordiyon, R.raw.cello, R.raw.darbuka, R.raw.keman, R.raw.mizika,
                    R.raw.tef, R.raw.klarnet, R.raw.melodika, R.raw.piyano, R.raw.gitar};
        }
        i = questionsLists.get(currentQuestionPosition).getPosition();
        mediaPlayer = MediaPlayer.create(QuizActivity.this, musics[i]);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        } else {
            Toast.makeText(QuizActivity.this, "Ses  dosyası oynatılamadı", Toast.LENGTH_SHORT).show();
        }


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option1.getText().toString();

                    option1.setBackgroundResource(R.drawable.round_back_red10);
                    option1.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSellectedAnswer(selectedOptionByUser);

                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option2.getText().toString();

                    option2.setBackgroundResource(R.drawable.round_back_red10);
                    option2.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSellectedAnswer(selectedOptionByUser);

                }

            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option3.getText().toString();

                    option3.setBackgroundResource(R.drawable.round_back_red10);
                    option3.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSellectedAnswer(selectedOptionByUser);

                }

            }
        });
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedOptionByUser.isEmpty()) {
                    selectedOptionByUser = option4.getText().toString();

                    option4.setBackgroundResource(R.drawable.round_back_red10);
                    option4.setTextColor(Color.WHITE);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSellectedAnswer(selectedOptionByUser);

                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mp.stop();
                if (selectedOptionByUser.isEmpty()) {
                    Toast.makeText(QuizActivity.this, "Please select an option.", Toast.LENGTH_SHORT).show();
                } else {
                    changeNextQuestion();
                    if (mediaPlayer != null) {
                        mediaPlayer.stop();
                    }
                    if (getSelectedTopicName.equals("song")) {
                        musics = new int[]{R.raw.guitar, R.raw.piano, R.raw.violin, R.raw.saxophone, R.raw.clairnet,
                                R.raw.drum, R.raw.oud, R.raw.electroguitar, R.raw.flute, R.raw.tambourine};
                    } else if (getSelectedTopicName.equals("instr")) {
                        musics = new int[]{R.raw.akordiyon, R.raw.cello, R.raw.darbuka, R.raw.keman, R.raw.mizika,
                                R.raw.tef, R.raw.klarnet, R.raw.melodika, R.raw.piyano, R.raw.gitar};
                    }
                    if (i != 11) {
                        i = questionsLists.get(currentQuestionPosition).getPosition();
                        mediaPlayer = MediaPlayer.create(QuizActivity.this, musics[i]);
                        if (mediaPlayer != null) {
                            mediaPlayer.start();
                        } else {
                            Toast.makeText(QuizActivity.this, "Ses  dosyası oynatılamadı", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTimer.purge();
                quizTimer.cancel();

                startActivity(new Intent(QuizActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    private void changeNextQuestion() {
        currentQuestionPosition++;
        if ((currentQuestionPosition + 1) == questionsLists.size()) {
            nextButton.setText("Submit Quiz");
        }
        if (currentQuestionPosition < questionsLists.size()) {
            selectedOptionByUser = "";

            option1.setBackgroundResource(R.drawable.round_back_white_stroke10_1);
            option1.setTextColor(Color.parseColor("#1F6BB8"));

            option2.setBackgroundResource(R.drawable.round_back_white_stroke10_1);
            option2.setTextColor(Color.parseColor("#1F6BB8"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke10_1);
            option3.setTextColor(Color.parseColor("#1F6BB8"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke10_1);
            option4.setTextColor(Color.parseColor("#1F6BB8"));

            questions.setText((currentQuestionPosition + 1) + "/" + questionsLists.size());

            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());

            option1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            option2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            option3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            option4.setText(questionsLists.get(currentQuestionPosition).getOption4());

        } else {
            Intent intent = new Intent(QuizActivity.this, QuizResults.class);
            i=11;
            intent.putExtra("correct", getCorrectAnswers());
            intent.putExtra("incorrect", getInCorrectAnswers());
            startActivity(intent);

            finish();
        }
    }

    private void startTimer(TextView timerTextViev) {

        quizTimer = new Timer();

        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (seconds == 0) {
                    totalTimeInMins--;
                    seconds = 59;
                } else if (seconds == 0 && totalTimeInMins == 0) {
                    quizTimer.purge();
                    quizTimer.cancel();

                    Toast.makeText(QuizActivity.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(QuizActivity.this, QuizResults.class);
                    intent.putExtra("correct", getCorrectAnswers());
                    intent.putExtra("incorrect", getInCorrectAnswers());
                    startActivity(intent);

                    finish();

                } else {
                    seconds--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalminutes = String.valueOf(totalTimeInMins);
                        String finalseconds = String.valueOf(seconds);

                        if (finalminutes.length() == 1) {
                            finalminutes = "00" + finalminutes;
                        }
                        if (finalseconds.length() == 1) {
                            finalseconds = "0" + finalseconds;
                        }
                        timerTextViev.setText(finalminutes + ":" + finalseconds);
                    }
                });
            }
        }, 1000, 1000);
    }

    private int getCorrectAnswers() {

        int correctAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSellectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private int getInCorrectAnswers() {

        int correctAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSellectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    @Override
    public void onBackPressed() {

        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this, MainActivity.class));
        finish();
    }

    private void revealAnswer() {
        final String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();
        if (option1.getText().toString().equals(getAnswer)) {
            option1.setBackgroundResource(R.drawable.round_back_green_23);
            option1.setTextColor(Color.WHITE);
        } else if (option2.getText().toString().equals(getAnswer)) {
            option2.setBackgroundResource(R.drawable.round_back_green_23);
            option2.setTextColor(Color.WHITE);

        } else if (option3.getText().toString().equals(getAnswer)) {
            option3.setBackgroundResource(R.drawable.round_back_green_23);
            option3.setTextColor(Color.WHITE);

        } else if (option4.getText().toString().equals(getAnswer)) {
            option4.setBackgroundResource(R.drawable.round_back_green_23);
            option4.setTextColor(Color.WHITE);

        }
    }
}