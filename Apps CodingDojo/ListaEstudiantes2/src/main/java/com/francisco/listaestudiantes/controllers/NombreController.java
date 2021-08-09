package com.francisco.listaestudiantes.controllers;

import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NombreController {
    private final ApiService apiService;

    public NombreController(ApiService apiService) {
        this.apiService = apiService;
    }
    @RequestMapping("/students/new")
    public String newStudent(
            @ModelAttribute("nombre") Nombre nombre) {
        return "/newStudent.jsp";
    }
    @PostMapping("/students/new")
    public String addStudent(
            @Valid
            @ModelAttribute("nombre") Nombre nombre, BindingResult result) {
        if (result.hasErrors()) {
            return "/contactInfo.jsp";
        } else {
            apiService.createNombre(nombre);
            return "redirect:/contact/new";
        }
    }
    @GetMapping("/students")
    public String showStudent(@Valid @ModelAttribute ("nombre") Nombre nombre, Model model){
        List<Nombre> nombres = apiService.allNombres();
        model.addAttribute("nombre", nombres);
        return "allStudents.jsp";
    }
}
