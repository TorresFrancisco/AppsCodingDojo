package com.francisco.languages.languages.services;

import com.francisco.languages.languages.models.Language;
import com.francisco.languages.languages.repostories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }
    public List<Language> allLanguage() {
        return languageRepository.findAll();
    }
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public Language updateLanguage(Language language){
        return languageRepository.save(language);
    }
    public void deleteLanguage(Long id){
        languageRepository.deleteById(id);
    }

}
