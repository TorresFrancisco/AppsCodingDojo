package com.francisco.listaestudiantes.controllers;

import com.francisco.listaestudiantes.models.Contacto;
import com.francisco.listaestudiantes.models.Dorm;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.services.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/api/students")
    public List<Nombre> index(){
        return apiService.allNombres();
    }

    @PostMapping("/api/students/create")
    public Nombre createStudent( @RequestParam(value = "firstName") String firstName,
                                 @RequestParam (value = "lastName") String lastName,
                                 @RequestParam(value = "age") Integer age,
                                 @RequestParam (value = "dorm") Dorm dorm) {
        Nombre nombre = new Nombre(firstName, lastName, age, dorm);
        return apiService.createNombre(nombre);
    }

    @PostMapping("/api/contacts/create")
    public Contacto createContacto(@RequestParam(value = "student")Long id,
                                   @RequestParam(value = "address") String address,
                                   @RequestParam(value = "city") String city,
                                   @RequestParam(value = "state") String state) {
        Nombre nombre = apiService.findNombre(id);
        Contacto contacto = new Contacto( nombre, address, city, state );
        return apiService.createContacto(contacto);
    }

    @RequestMapping("/api/dorms")
    public List<Dorm> indexDorms(){
        return apiService.allDorms();
    }

    @GetMapping("/api/dorms/{id}")
    public List<Nombre> allNombreDorm(@PathVariable("id")Long id) {
        Dorm dorm = apiService.findDorm(id);
        List<Nombre> nombres = dorm.getNombres();
        return nombres;
    }

    @PostMapping("/api/dorms/create")
    public Dorm createDorm(@RequestParam(value = "name") String name) {
        Dorm dorm = new Dorm( name );
       return apiService.createDorm(dorm);
    }

    @PostMapping("/api/dorms/{id}/add")
    public Nombre addStudent(@PathVariable("id") Long id,
                             @RequestParam("nombre") Long idNombre){
        Dorm dorm = apiService.findDorm(id);
        Nombre nombre = apiService.findNombre(idNombre);
        nombre.setDorm(dorm);
        return  apiService.createNombre(nombre);
    }

    @PutMapping("/api/dorms/{id}/remove")
    public Nombre deleteStudent(@PathVariable("id") Long id,
                             @RequestParam( value = "nombre") Long idNombre){
        Nombre nombre = apiService.findNombre(idNombre);
        nombre.setDorm(null);
        return  apiService.createNombre(nombre);
    }
}
