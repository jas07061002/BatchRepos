package com.springbatchexample1.config;

import com.springbatchexample1.model.MockData;
import org.springframework.batch.item.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

class RestEmployeeReader implements ItemReader<MockData> {

    private final String apiUrl;
    private final RestTemplate restTemplate;

    private int nextStudentIndex;
    private List<MockData> studentData;

    RestEmployeeReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextStudentIndex = 0;
    }

    @Override
    public MockData read() throws Exception {
        if (studentDataIsNotInitialized()) {
            studentData = fetchStudentDataFromAPI();
        }

        MockData nextStudent = null;

        if (nextStudentIndex < studentData.size()) {
            nextStudent = studentData.get(nextStudentIndex);
            nextStudentIndex++;
        }
        else {
            nextStudentIndex = 0;
            studentData = null;
        }

        return nextStudent;
    }

    private boolean studentDataIsNotInitialized() {
        return this.studentData == null;
    }

    private List<MockData> fetchStudentDataFromAPI() {
        ResponseEntity<MockData[]> response = restTemplate.getForEntity(apiUrl,
                MockData[].class
        );
        MockData[] studentData = response.getBody();
        return Arrays.asList(studentData);
    }
}