package com.example.propra2proj.Model;



import java.util.List;

public class Course {

    private int id;
    private String name;
    private Organiser organiser;
    private List<Student> studentList;
    private List<Test_Exam> examList;

    public Course(int id, String name, Organiser organiser, List<Student> studentList, List<Test_Exam> examList) {
        this.id = id;
        this.name = name;
        this.organiser = organiser;
        this.studentList = studentList;
        this.examList = examList;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Organiser getOrganiser() {
        return organiser;
    }
    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public List<Test_Exam> getExamList() {
        return examList;
    }
    public void setExamList(List<Test_Exam> examList) {
        this.examList = examList;
    }

}
