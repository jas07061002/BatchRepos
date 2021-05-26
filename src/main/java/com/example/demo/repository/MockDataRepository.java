package com.example.demo.repository;

import com.example.demo.model.MockData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockDataRepository extends JpaRepository<MockData,Integer> {
}
