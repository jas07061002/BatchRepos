package com.example.demo.controller;

import com.example.demo.model.MockData;
import com.example.demo.repository.MockDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockController {

    @Autowired
    MockDataRepository mockDataRepository;

    @GetMapping(path = "/dataInfo")
    public ResponseEntity<List<MockData>> getAllMockData() {

        return ResponseEntity.ok(mockDataRepository.findAll());
    }
}
