package com.francisco.listaestudiantes.controllers;

import com.francisco.listaestudiantes.models.Dorm;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.services.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DormController {
    private final ApiService apiService;

    public DormController(ApiService apiService) {
        this.apiService = apiService;
    }
    @RequestMapping("/dorms/new")
    public String newDorms(
            @ModelAttribute("dorm") Dorm dorm) {
        return "/dorm.jsp";
    }
    @PostMapping("/dorms/new")
    public String addDorm(
            @Valid
            @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "/dorm.jsp";
        } else {
            apiService.createDorm(dorm);
            return "redirect:/dorms/"+ dorm.getId();
        }
    }
    @PostMapping("/dorms/{id}")
    public String addDorm(
            @PathVariable("id") Long id, Model model) {
            Dorm dorm = apiService.findDorm(id);
            apiService.createDorm(dorm);
            return "redirect:/dorms/"+ dorm.getId();
        }

    @GetMapping("/dorms/{id}")
    public String showDorm(
            @PathVariable("id") Long id, Model model){
        Dorm dorm = apiService.findDorm(id);
        apiService.createDorm(dorm);
        List<Nombre> nombres = apiService.allNombres();
        model.addAttribute("nombres",nombres);
        if (dorm == null) {
            return "/dorms/new";
        } else {
            model.addAttribute("dorm", dorm);
            return "showDorm.jsp";
        }
    }        @DeleteMapping("/dorms/{id}")
    public String deleteStudents(
            @PathVariable("id") Long id){
        apiService.deleteNombre(id);
        return "redirect:/dorms/";

    }
}
