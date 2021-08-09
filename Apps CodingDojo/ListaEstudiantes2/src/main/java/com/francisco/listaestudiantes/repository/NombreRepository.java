package com.francisco.listaestudiantes.repository;

import com.francisco.listaestudiantes.models.Nombre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NombreRepository extends CrudRepository<Nombre, Long> {

    List<Nombre> findAll();

//    List<Nombre> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
