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
import javax.persistence.UniqueConstraint;



@Entity
public class Authors implements Serializable{
    
     /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAuthors;
    private String name;
    private String nationalIdentity;
    private String email;

    @ManyToMany
    @JoinTable(
        name="BooksAuthors",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_authors","id_book"}),
        joinColumns = @JoinColumn(name="id_authors"),
        inverseJoinColumns = @JoinColumn(name="id_book")
    )
    private List<Books> books;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(Integer idAuthors) {
        this.idAuthors = idAuthors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }

   
    
    
}