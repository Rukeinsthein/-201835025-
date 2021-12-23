package com.example.a201835025;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String selectedTopicName = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout song = findViewById(R.id.songlayout);
        final LinearLayout instr = findViewById(R.id.instrumantellayout);

        final Button startBtn = findViewById(R.id.startQuizBtn);



        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectedTopicName = "song";

                song.setBackgroundResource(R.drawable.round_back_white_stroke10);

                instr.setBackgroundResource(R.drawable.roundbacktowhite);
            }
        });

        instr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedTopicName = "instr";

                instr.setBackgroundResource(R.drawable.round_back_white_stroke10);

                song.setBackgroundResource(R.drawable.roundbacktowhite);
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedTopicName.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Select the Topic", Toast.LENGTH_SHORT).show();
                }
                else{

                    Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                    intent.putExtra("selectedTopic", selectedTopicName);
                    startActivity(intent);
                }
            }
        });
    }
}