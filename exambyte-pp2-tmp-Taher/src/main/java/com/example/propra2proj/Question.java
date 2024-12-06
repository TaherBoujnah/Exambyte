package com.example.propra2proj;

public interface Question {
    String getQuestion();
    String getAnswer();
    int getScore();
    String getQuestionType();
    void setScore(int score);
    void setQuestion(String question);
    void setAnswer(String answer);



}
