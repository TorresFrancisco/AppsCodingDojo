package com.francisco.relationships.repository;

import com.francisco.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    List<License> findAll();

//    List<License> findByDescriptionContaining(String search);

//    Long countByTitleContaining(String search);

//    Long deleteByTitleStartingWith(String search);
}
