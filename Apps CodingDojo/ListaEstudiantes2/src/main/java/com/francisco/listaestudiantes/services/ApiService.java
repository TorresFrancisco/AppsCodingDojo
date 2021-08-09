package com.francisco.listaestudiantes.services;

import com.francisco.listaestudiantes.models.Contacto;
import com.francisco.listaestudiantes.models.Dorm;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.repository.ContactoRepository;
import com.francisco.listaestudiantes.repository.DormRepository;
import com.francisco.listaestudiantes.repository.NombreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final NombreRepository nombreRepository;
    private final ContactoRepository contactoRepository;
    private final DormRepository dormRepository;

    public ApiService(NombreRepository nombreRepository, ContactoRepository contactoRepository, DormRepository dormRepository) {
        this.nombreRepository = nombreRepository;
        this.contactoRepository = contactoRepository;
        this.dormRepository = dormRepository;
    }

    public List<Nombre> allNombres(){
        return nombreRepository.findAll();
    }
    public void deleteNombre(Long id){
        nombreRepository.deleteById(id);
    }

    public Nombre createNombre(Nombre s) {
        return nombreRepository.save(s);
    }

    public Nombre findNombre(Long id) {
        Optional<Nombre> optionalNombre = nombreRepository.findById(id);
        if (optionalNombre.isPresent()) {
            return optionalNombre.get();
        }
        else {
            return null;
        }
    }

    public List<Contacto> allContacts(){
        return contactoRepository.findAll();
    }

    public Contacto createContacto(Contacto c) {
        return contactoRepository.save(c);
    }

    public Contacto findContacto(Long id) {
        Optional<Contacto> optionalContacto = contactoRepository.findById(id);
        if (optionalContacto.isPresent()) {
            return optionalContacto.get();
        }
        else {
            return null;
        }
    }

    public List<Dorm> allDorms(){
        return dormRepository.findAll();
    }

    public Dorm createDorm(Dorm l) {
        return dormRepository.save(l);
    }

    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if (optionalDorm.isPresent()) {
            return optionalDorm.get();
        }
        else {
            return null;
        }
    }


}

