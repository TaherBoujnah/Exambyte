package com.example.propra2proj.Model;

import java.util.List;

public class MultipleChoiceQuestion implements Question {

    private String question;
    private String answer;
    private List<String> options;
    private int score;

    public MultipleChoiceQuestion(String question, String answer, List<String> options, int score) {
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.score = score;
    }


    @Override
    public String getQuestion() {
        return this.question;
    }

    @Override
    public String getAnswer() {
        return this.answer ;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public String getQuestionType() {
        return getClass().getName() ;
    }

    @Override
    public void setScore(int score) {
     this.score = score;
    }

    @Override
    public void setQuestion(String question) {
     this.question = question;
    }

    @Override
    public void setAnswer(String answer) {
     this.answer = answer;
    }

    public List<String> getOptions() {
        return options;
    }
    public void setOptions(List<String> options) {
        this.options = options;
    }

}
