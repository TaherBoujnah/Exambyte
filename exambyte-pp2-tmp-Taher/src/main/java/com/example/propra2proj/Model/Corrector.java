package com.example.propra2proj.Model;


import java.util.List;

public class Corrector extends User {

    private List<Test_Exam> assignedExams;
    private List<Course> courses;

    public Corrector(int id, String name, String email, List<Course> courses, List<Test_Exam> assignedExams) {
        super(id, name, email, Role.ROLE_CORRECTOR);
        this.assignedExams = assignedExams;
        this.courses = courses;
    }
    public List<Test_Exam> getAssignedExams() {
        return assignedExams;
    }

    public void setAssignedExams(List<Test_Exam> assignedExams) {
        this.assignedExams = assignedExams;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String getDashboard() {
        return "/Corrector/Corrector_Dashboard";
    }

}
