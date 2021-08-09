package com.francisco.dojosninjas.controllers;

import com.francisco.dojosninjas.models.Dojo;
import com.francisco.dojosninjas.models.Ninja;
import com.francisco.dojosninjas.services.DojoService;
import com.francisco.dojosninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("ninjas/new")
    public String newNinjas(
            @ModelAttribute("ninja") Ninja ninja, Model model ){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        model.addAttribute("ninja", ninja);
        return "ninjas.jsp";
    }

    @PostMapping("ninjas/new")
    public String addNinjas(
            @Valid
            @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "ninjas.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos/"+ninja.getDojo().getId();
        }
    }
}
