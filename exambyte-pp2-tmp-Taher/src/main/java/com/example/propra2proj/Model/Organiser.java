package com.example.propra2proj.Model;

import java.util.List;

public class Organiser extends User{

    private List<Course> createdCourses;
    private List<Test_Exam> createdExams;
    public Organiser(int id, String name, String email, List <Course> createdcourses, List <Test_Exam> createdexams) {
        super(id, name, email, Role.ROLE_ORGANIZER);
        this.createdCourses= createdcourses;
        this.createdExams = createdexams;
    }
    public List<Course> getCreatedCourses() {
        return createdCourses;
    }
    public void setCreatedCourses(List<Course> createdCourses) {
        this.createdCourses = createdCourses;
    }
    public List<Test_Exam> getCreatedExams() {
        return createdExams;
    }
    public void setCreatedExams(List<Test_Exam> createdexams) {
        this.createdExams = createdexams;
    }


    @Override
    public String getDashboard() {
        return "/Organiser/Organiser_Dashboard";
    }
}
