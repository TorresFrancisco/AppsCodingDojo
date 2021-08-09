package com.francisco.dojooverflow.repository;

import com.francisco.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

    List<Tag> findAll();

    Optional<Tag> findBySubject(String subject);

}
