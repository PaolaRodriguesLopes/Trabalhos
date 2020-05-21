package com.example.atividade3_paolarodrigues_180115.service;

import java.util.List;

import com.example.atividade3_paolarodrigues_180115.entity.Publishers;
import com.example.atividade3_paolarodrigues_180115.repository.PublishersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishersService {
    
    @Autowired
    private PublishersRepository pr;


    public List<Publishers> getPublishers()
    {
        return pr.findAll();
    }

    public void insert (Publishers publishers)
    {
        pr.save(publishers);
    }

    public Publishers getPublisherById(int id)
    {
        return pr.findById(id).get();
    }

    public void deletePublisher (Publishers publisher)
    {
        pr.delete(publisher);
    }
}