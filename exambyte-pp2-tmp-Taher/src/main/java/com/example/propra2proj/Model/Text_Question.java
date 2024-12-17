package com.example.propra2proj.Model;

public class Text_Question implements Question {

    private String question;
    private String potentialAnswer;
    private int Score;

    public Text_Question(String question, String potentialAnswer, int Score) {
        this.question = question;
        this.potentialAnswer = potentialAnswer;
        this.Score = Score;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAnswer() {
        return this.potentialAnswer;
    }

    @Override
    public int getScore() {
        return this.Score;
    }

    @Override
    public String getQuestionType() {
        return getClass().getName();
    }

    @Override
    public void setScore(int score) {
     this.Score = score;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;

    }

    @Override
    public void setAnswer(String answer) {
        this.potentialAnswer = answer;

    }


}
