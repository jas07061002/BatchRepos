package com.springbatchexample1.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee person = new Employee();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setDept(rs.getString("dept"));
        person.setSalary(rs.getInt("salary"));
        person.setJoiningdate(rs.getDate("joiningdate"));

        return person;
    }

}