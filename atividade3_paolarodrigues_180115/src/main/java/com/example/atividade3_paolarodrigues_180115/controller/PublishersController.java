package com.example.atividade3_paolarodrigues_180115.controller;

import com.example.atividade3_paolarodrigues_180115.entity.Publishers;
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
public class PublishersController {
    
    @Autowired
    private PublishersService ps;

    @Autowired
    private BooksService bs;


    @GetMapping("/publishers")
    public ModelAndView getPublishers()
    {
        ModelAndView mv = new ModelAndView("PublishersTemplates");

        mv.addObject("publishers", ps.getPublishers());

        return mv;
    }

    @GetMapping("/about")
    public ModelAndView getAbout()
    {
        ModelAndView mv = new ModelAndView("AboutTemplate");

        

        return mv;
    }

    
    @GetMapping("/detailsBooks/{id}")
    public ModelAndView getDetailsBooks(@PathVariable(name="id") Integer id)
    {
        Publishers pu = ps.getPublisherById(id);
        ModelAndView mv = new ModelAndView("DetailsBooksView");

        mv.addObject("details", pu);

        return mv;
    }

    @PostMapping("/insertPublishers")
    public String insert (@ModelAttribute Publishers publishers)
    {
        ps.insert(publishers);

        return "redirect:/publishers";
    }

    @GetMapping("/deletePublisher")
    public String delete (@RequestParam Integer id)
    {
        String res = "";
        Publishers publi = ps.getPublisherById(id);

        if (!publi.getBooks().isEmpty())
        {
            res = "redirect:/erro";
        }else{
            ps.deletePublisher(publi);
            res = "redirect:/publishers";
        }
        

        return res;
    }

    @GetMapping("/updatePublisher")
    public ModelAndView updatePubli (@RequestParam Integer id)
    {
        ModelAndView mv = new ModelAndView("PublishresUpdate");

        Publishers publi = ps.getPublisherById(id);
        

        mv.addObject("publi", publi);
        mv.addObject("booksP", bs.getBooks());


        return mv;
    }
}