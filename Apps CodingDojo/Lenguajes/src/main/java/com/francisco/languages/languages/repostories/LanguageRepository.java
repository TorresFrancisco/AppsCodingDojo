package com.francisco.languages.languages.repostories;

import com.francisco.languages.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

    List<Language> findAll();

    List<Language> findByNameContaining(String search);

}
