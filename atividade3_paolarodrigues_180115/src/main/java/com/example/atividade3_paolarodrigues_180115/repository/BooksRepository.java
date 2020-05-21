package com.example.atividade3_paolarodrigues_180115.repository;

import com.example.atividade3_paolarodrigues_180115.entity.Books;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository <Books, Integer>{
    
}