package com.example.sb1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sb1.model.Student;

public interface StudentRepository extends JpaRepository< Student , Long>{
    
}
