package com.francisco.relationships.repository;


import com.francisco.relationships.models.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findAll();

//    List<Person> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}

