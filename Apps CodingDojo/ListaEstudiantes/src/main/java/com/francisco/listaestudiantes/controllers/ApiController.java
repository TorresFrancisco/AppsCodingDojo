package com.francisco.listaestudiantes.controllers;

import com.francisco.listaestudiantes.models.Contacto;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.services.ApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/students")
    public List<Nombre> index(){
        return apiService.allNombres();
    }

    @PostMapping("/students/create")
    public Nombre createStudent(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam (value = "lastName") String lastName,
                                 @RequestParam(value = "age") Integer age) {
        Nombre nombre = new Nombre(firstName, lastName, age);
        return apiService.createNombre(nombre);
    }

    @PostMapping("/contacts/create")
    public Contacto createContacto(@RequestParam(value = "student")Long id,
                                   @RequestParam(value = "address") String address,
                                   @RequestParam(value = "city") String city,
                                   @RequestParam(value = "state") String state) {
        Nombre nombre = apiService.findNombre(id);
        Contacto contacto = new Contacto( nombre, address, city, state );
        return apiService.createContacto(contacto);
    }
}
