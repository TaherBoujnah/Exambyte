package com.example.propra2proj.Model;

import java.util.List;

public class Student extends User{
    private List <Course> courses;
    private List<TestResult> testResults;


    public Student(int id, String name, String email, List <Course> courses, List <TestResult> testResults) {
        super(id, name, email, Role.ROLE_STUDENT);
        this.courses = courses;
        this.testResults = testResults;
    }
    public List <Course> getCourses() {
        return courses;
    }
    public void setCourses(List <Course> courses) {
        this.courses = courses;
    }
    public List<TestResult> getTestResults() {
        return testResults;
    }
    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    @Override
    public String getDashboard() {
        return "/Student/student_dashboard";
    }

}
