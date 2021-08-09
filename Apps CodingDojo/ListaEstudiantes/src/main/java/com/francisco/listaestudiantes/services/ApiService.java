package com.francisco.listaestudiantes.services;

import com.francisco.listaestudiantes.models.Contacto;
import com.francisco.listaestudiantes.models.Nombre;
import com.francisco.listaestudiantes.repository.ContactoRepository;
import com.francisco.listaestudiantes.repository.NombreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final NombreRepository nombreRepository;
    private final ContactoRepository contactoRepository;

    public ApiService(NombreRepository nombreRepository, ContactoRepository contactoRepository) {
        this.nombreRepository = nombreRepository;
        this.contactoRepository = contactoRepository;
    }

    public List<Nombre> allNombres(){
        return nombreRepository.findAll();
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
}

