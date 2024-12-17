package com.example.propra2proj.Repository;

import com.example.propra2proj.Mapper.TestExamRowMapper;
import com.example.propra2proj.Model.Test_Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestExamRepository {

    private final JdbcTemplate db;

    @Autowired
    public TestExamRepository(JdbcTemplate db) {
        this.db = db;
    }

    public List<Test_Exam> getTestExam (){
        return null;}

    public static List<Test_Exam> findByCreatedByUsername(String username)
    {
        return null;
    }





}

