package com.francisco.listaestudiantes.repository;

import com.francisco.listaestudiantes.models.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {

    List<Contacto> findAll();

//    List<Contacto> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
