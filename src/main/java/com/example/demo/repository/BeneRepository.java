package com.example.demo.repository;

import com.example.demo.model.GeneralTrustBene;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneRepository extends JpaRepository<GeneralTrustBene,Integer> {
}
