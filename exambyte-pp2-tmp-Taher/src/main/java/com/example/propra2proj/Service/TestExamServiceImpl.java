package com.example.propra2proj.Service;

import com.example.propra2proj.Model.Test_Exam;
import com.example.propra2proj.Repository.TestExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestExamServiceImpl implements TestExamService {
private final TestExamService testExamService;
@Autowired
public TestExamServiceImpl(TestExamService testExamService) {
    this.testExamService = testExamService;
}

    @Override
    public List<Test_Exam> getAllTests() {
        return (List<Test_Exam>) testExamService.getAllTests();
    }

    @Override
    public Test_Exam getTestById(int id) {
        return null;
    }

    @Override
    public void createTest(Test_Exam test) {

    }

    @Override
    public void deleteTest(int id) {

    }
    @Override
    public List<Test_Exam> findExamsByCreator(String username) {
        return TestExamRepository.findByCreatedByUsername(username);
    }

}
