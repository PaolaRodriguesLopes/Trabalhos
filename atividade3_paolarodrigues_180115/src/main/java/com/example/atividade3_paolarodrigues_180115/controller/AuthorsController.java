package com.example.atividade3_paolarodrigues_180115.controller;

import com.example.atividade3_paolarodrigues_180115.entity.Authors;
import com.example.atividade3_paolarodrigues_180115.service.AuthorsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorsController {
    
    @Autowired
    private AuthorsService as;

    @GetMapping("/authors")
    public ModelAndView getAuthors()
    {
        ModelAndView mv = new ModelAndView("AuthorsTemplates");

        mv.addObject("authors", as.getAuthors());

        return mv;
    }

    @PostMapping("/insertAuthors")
    public String insert (@ModelAttribute Authors authors)
    {
        as.insert(authors);

        return "redirect:/authors";
    }

    @GetMapping("/updateAuthors")
    public ModelAndView updateAuthors (@RequestParam Integer id)
    {
        ModelAndView mv = new ModelAndView("AuthorsUpdate");

        Authors author = as.getAuthorById(id);

        mv.addObject("author", author);


        return mv;
    }

    @GetMapping("/detailsBooksByAuthor/{id}")
    public ModelAndView getDetailsBooks(@PathVariable(name="id") Integer id)
    {
        Authors au =as.getAuthorById(id);
        ModelAndView mv = new ModelAndView("DetailsBooksView");

        mv.addObject("details", au);
        mv.addObject("books", au.getBooks());

        return mv;
    }

    @GetMapping("/deleteAuthor")
    public String delete (@RequestParam Integer id)
    {
        String res = "";
        Authors au =as.getAuthorById(id);


        if (!au.getBooks().isEmpty())
        {
            res = "redirect:/erro";
        }else{
            as.deleteAuthor(au); 
            res = "redirect:/authors";        
        }
        return res;
    }

    @GetMapping("/erro")
    public ModelAndView getError()
    {
        System.out.println("Entrou get mapping");
        ModelAndView mv = new ModelAndView("ErrorPage");       
        return mv;
    }
}