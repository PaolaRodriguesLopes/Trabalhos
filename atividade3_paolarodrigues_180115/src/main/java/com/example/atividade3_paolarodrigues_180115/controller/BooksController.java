package com.example.atividade3_paolarodrigues_180115.controller;

import com.example.atividade3_paolarodrigues_180115.entity.Authors;
import com.example.atividade3_paolarodrigues_180115.entity.Books;
import com.example.atividade3_paolarodrigues_180115.service.AuthorsService;
import com.example.atividade3_paolarodrigues_180115.service.BooksService;
import com.example.atividade3_paolarodrigues_180115.service.PublishersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BooksController {

    @Autowired
    private BooksService bs;

    @Autowired
    private PublishersService publiService;

    @Autowired
    private AuthorsService authorService;

    @GetMapping("/books")
    public ModelAndView getBooks()
    {
        ModelAndView mv = new ModelAndView("BooksTemplates");

        mv.addObject("book", new Books());
        mv.addObject("books", bs.getBooks());
        mv.addObject("publi", publiService.getPublishers());
        

        return mv;
    }

    @PostMapping("/insertBooks")
    public String insert (@ModelAttribute Books books)
    {
        bs.insert(books);

        return "redirect:/books";
    }

    @PostMapping("/BooksAuthors")
    public String setBooksAuthors (@ModelAttribute Authors author, @RequestParam Integer idBook)
    {
        Books book = bs.getBooksById(idBook);
        
        author = authorService.getAuthorById(author.getIdAuthors());

        book.getAuthors().add(author);
        bs.insert(book);

        return "redirect:/detailsBooksAuthors/" + idBook;
    }

    @GetMapping("/detailsBooksAuthors/{id}")
    public ModelAndView getBooksAuthors (@PathVariable(name="id") Integer id)
    {
        Books book = bs.getBooksById(id);
        ModelAndView mv = new ModelAndView("DetailsAuthorsView");
        mv.addObject("books", book);

        java.util.List<Authors> authorsNot = authorService.getAuthors();
        authorsNot.removeAll(book.getAuthors());
        mv.addObject("authors", authorsNot);

        return mv;
    }

    @GetMapping("/deleteBook")
    public String delete (@RequestParam Integer id)
    {
        Books book = bs.getBooksById(id);
        bs.deleteBook(book);

        return "redirect:/books";
    }

    @GetMapping("/updateBook")
    public ModelAndView updateBook (@RequestParam Integer id)
    {
        ModelAndView mv = new ModelAndView("BooksUpdate");

        Books book = bs.getBooksById(id);
        
        mv.addObject("book", book);
        mv.addObject("publi", publiService.getPublishers());

        java.util.List<Authors> authorsNot = authorService.getAuthors();
        authorsNot.removeAll(book.getAuthors());
        mv.addObject("authorsB", authorsNot);


        return mv;
    }
    
}