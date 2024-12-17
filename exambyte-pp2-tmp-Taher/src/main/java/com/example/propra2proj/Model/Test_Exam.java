package com.example.propra2proj.Model;

import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Test_Exam {
    @Id
    private int id ;
    private String name ;
    private int overallScore;
    private List<Question> questions;
    private Organiser createdBy;
    private Course course;
    private LocalDateTime dateTime;

    public Test_Exam(int id, String name, int overallScore, List<Question> questions, Organiser createdBy, Course course, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.overallScore = overallScore;
        this.questions = questions;
        this.createdBy = createdBy;
        this.course = course;
        this.dateTime = dateTime;
    }


    public List<Question> getQuestions() {
        return this.questions;
    }
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    public int getOverallScore() {
        return this.overallScore;
    }
    public void setOverallScore(int OverallScore) {
        this.overallScore = OverallScore;
    }
    public Organiser getCreatedBy() {
        return this.createdBy;
    }
    public void setCreatedBy(Organiser createdBy) {
        this.createdBy = createdBy;
    }
    public Course getCourse() {
        return this.course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public LocalDateTime getDateTime() {
        return this.dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
