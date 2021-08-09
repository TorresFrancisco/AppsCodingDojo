package com.francisco.dojosninjas.controllers;

import com.francisco.dojosninjas.models.Dojo;
import com.francisco.dojosninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }
    @RequestMapping("/dojos/new")
    public String newDojo(
            @ModelAttribute("dojo") Dojo dojo) {
        return "/dojos.jsp";
    }
    @PostMapping("/dojos/new")
    public String addDojo(
            @Valid
            @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/ninjas.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }
    @RequestMapping("/dojos/{id}")
    public String details(
            @PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.findDojo(id);
        if (dojo == null) {
            return "/dojos/new";
        } else {
            model.addAttribute("dojo", dojo);
            return "allDojos.jsp";
        }
    }
}
