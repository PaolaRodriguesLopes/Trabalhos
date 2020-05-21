package com.example.atividade3_paolarodrigues_180115.repository;

import com.example.atividade3_paolarodrigues_180115.entity.Authors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository <Authors, Integer>{
    
}