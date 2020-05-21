package com.example.atividade3_paolarodrigues_180115.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;


@Entity
public class Books implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;
    private String title;

    @ManyToMany
    @JoinTable(
        name="BooksAuthors",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_authors","id_book"}),
        joinColumns = @JoinColumn(name="id_book"),
        inverseJoinColumns = @JoinColumn(name="id_authors")
    )
    private List<Authors> authors;

    @ManyToOne
    @JoinColumn(name="ID_PUBLISHER_BOOK")
    private Publishers publisher;
    private Double price;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public Publishers getPublisher() {
        return publisher;
    }

    public void setPublisher(Publishers publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
    

    
}