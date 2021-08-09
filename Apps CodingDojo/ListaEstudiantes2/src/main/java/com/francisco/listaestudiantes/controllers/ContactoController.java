package com.francisco.listaestudiantes.controllers;

import com.francisco.listaestudiantes.models.Contacto;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ContactoController {
    private final ApiService apiService;

    public ContactoController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("contact/new")
    public String newContact(
            @ModelAttribute("contacto") Contacto contacto, Model model ){
        List<Nombre> nombres = apiService.allNombres();
        model.addAttribute("nombres", nombres);
        model.addAttribute("contacto", contacto);
        return "contactInfo.jsp";
    }

    @PostMapping("contact/new")
    public String addContact(
            @Valid
            @ModelAttribute("contacto") Contacto contacto, BindingResult result) {
        if (result.hasErrors()) {
            return "contactInfo.jsp";
        } else {
            apiService.createContacto(contacto);
            return "redirect:/students/";
        }
    }
}
