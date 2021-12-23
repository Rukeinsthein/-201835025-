package com.example.a201835025;

public class QuestionsList {

    private String question, option1, option2, option3, option4, answer;
    private String userSellectedAnswer;
    private int position;


    public QuestionsList(String question, String option1, String option2, String option3, String option4, String answer, String userSellectedAnswer, int position) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.userSellectedAnswer = userSellectedAnswer;
        this.position = position;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getUserSellectedAnswer() {
        return userSellectedAnswer;
    }

    public void setUserSellectedAnswer(String userSellectedAnswer) {
        this.userSellectedAnswer = userSellectedAnswer;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
