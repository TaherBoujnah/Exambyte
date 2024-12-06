package com.example.propra2proj;

import java.util.List;

public class Test_Exam {
    private int numberOfQuestions;
    private List<Question> questions;
    private int OverallScore;

    public Test_Exam(int numberOfQuestions, List<Question> questions, int OverallScore) {
        this.numberOfQuestions = numberOfQuestions;
        this.questions = questions;
        this.OverallScore = OverallScore;

    }
    public int getnumberOfQuestions() {
        return this.numberOfQuestions;
    }
    public void setExamName(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
    public List<Question> getQuestions() {
        return this.questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public int getOverallScore() {
        return this.OverallScore;
    }
    public void setOverallScore(int OverallScore) {
        this.OverallScore = OverallScore;
    }

}
