package com.example.propra2proj.Service;

import com.example.propra2proj.Model.Test_Exam;

import java.util.List;

public interface TestExamService {
    List<Test_Exam> getAllTests();
    Test_Exam getTestById(int id);
    void createTest(Test_Exam test);
    void deleteTest(int id);
    public List<Test_Exam> findExamsByCreator(String username);
}
