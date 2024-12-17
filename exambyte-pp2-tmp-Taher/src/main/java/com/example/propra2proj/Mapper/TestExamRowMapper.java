package com.example.propra2proj.Mapper;

import com.example.propra2proj.Model.Test_Exam;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestExamRowMapper implements RowMapper<Test_Exam> {

    @Override
    public Test_Exam mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
