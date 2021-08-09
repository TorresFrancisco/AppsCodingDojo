package com.francisco.dojosninjas.repository;

import com.francisco.dojosninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();

//    List<Dojo> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
