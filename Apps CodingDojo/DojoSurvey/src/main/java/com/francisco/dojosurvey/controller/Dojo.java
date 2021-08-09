package com.francisco.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dojo {
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }
    @RequestMapping(value = "result", method = RequestMethod.POST)
    public String pag(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "language") String language,
            @RequestParam(value = "comment") String comment,
            Model model
    ){
        model.addAttribute("name", name);
        model.addAttribute("location", location);
        model.addAttribute("language", language);
        model.addAttribute("comment", comment);
        return "pag.jsp";
    }

}
