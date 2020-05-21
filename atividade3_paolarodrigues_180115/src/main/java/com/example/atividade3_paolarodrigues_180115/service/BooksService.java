package com.example.atividade3_paolarodrigues_180115.service;

import java.util.List;

import com.example.atividade3_paolarodrigues_180115.entity.Books;
import com.example.atividade3_paolarodrigues_180115.repository.BooksRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {
    
    @Autowired
    private BooksRepository br;

    public List<Books> getBooks()
    {
        return br.findAll();
    }

    public void insert (Books books)
    {
        br.save(books);
    }

    public Books getBooksById(int id)
    {
        return br.findById(id).get();
    }

    public void deleteBook (Books book)
    {
        br.delete(book);
    }
}