/*
package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.Employee;
import com.techprimers.springbatchexample1.repository.EmployeeRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Employee> {

    private EmployeeRepository employeeRepository;

    @Autowired
    public DBWriter (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void write(List<? extends Employee> users) throws Exception{
        System.out.println("Data Saved for Users: " + users);
        employeeRepository.saveAll(users);
    }
}
*/
