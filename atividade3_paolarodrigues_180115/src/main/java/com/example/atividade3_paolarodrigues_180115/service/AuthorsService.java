package com.example.atividade3_paolarodrigues_180115.service;

import java.util.List;

import com.example.atividade3_paolarodrigues_180115.entity.Authors;
import com.example.atividade3_paolarodrigues_180115.repository.AuthorsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    
    @Autowired
    private AuthorsRepository ar;

    public List<Authors> getAuthors()
    {
        return ar.findAll();
    }

    public void insert (Authors authors)
    {
        ar.save(authors);
    }


    public Authors getAuthorById(int id)
    {
        return ar.findById(id).get();
    }

    public void deleteAuthor (Authors author)
    {
        ar.delete(author);
    }
}