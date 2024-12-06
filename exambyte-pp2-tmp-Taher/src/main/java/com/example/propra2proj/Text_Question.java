package com.example.propra2proj;

public class Text_Question implements Question{

    private String question;
    private String PotentialAnswer;
    private int Score;

    public Text_Question(String question, String PotentialAnswer, int Score) {
        this.question = question;
        this.PotentialAnswer = PotentialAnswer;
        this.Score = Score;
    }

    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAnswer() {
        return this.PotentialAnswer;
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
        this.PotentialAnswer = answer;

    }


}
