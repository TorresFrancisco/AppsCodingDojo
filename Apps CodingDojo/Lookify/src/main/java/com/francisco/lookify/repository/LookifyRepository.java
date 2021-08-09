package com.francisco.lookify.repository;

import com.francisco.lookify.models.Lookify;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LookifyRepository extends CrudRepository<Lookify, Long> {

    List<Lookify> findAll();

    List<Lookify> findByTitleContaining(String search);

    List<Lookify> findTop10ByOrderByRatingDesc();

    List<Lookify> findByArtistContaining(String search);

}
