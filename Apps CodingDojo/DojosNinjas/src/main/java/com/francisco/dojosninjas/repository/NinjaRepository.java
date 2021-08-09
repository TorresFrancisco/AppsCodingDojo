package com.francisco.dojosninjas.repository;

import com.francisco.dojosninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {

    List<Ninja> findAll();

//    List<Ninja> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
