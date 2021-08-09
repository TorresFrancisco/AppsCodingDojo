package com.francisco.listaestudiantes.repository;

import com.francisco.listaestudiantes.models.Dorm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DormRepository extends CrudRepository<Dorm, Long> {

      List<Dorm> findAll();

//    List<Dorm> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
