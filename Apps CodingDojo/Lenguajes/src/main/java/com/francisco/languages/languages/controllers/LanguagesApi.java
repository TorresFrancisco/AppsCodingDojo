package com.francisco.languages.languages.controllers;

import com.francisco.languages.languages.services.LanguageService;
import com.francisco.languages.languages.models.Language;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LanguagesApi {
    private final LanguageService languageService;
    public LanguagesApi(LanguageService languageService){

        this.languageService = languageService;
    }

    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguage();
    }

    @RequestMapping(value="/api/languages", method= RequestMethod.POST)
    public Language create(
            @RequestParam(value="name") String name,
            @RequestParam(value="creator") String creator,
            @RequestParam(value="version") Double version)
    {
        Language language = new Language(name, creator, version);
        return languageService.createLanguage(language);
    }

    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id,
                       @RequestParam(value="name") String name,
                       @RequestParam(value="creator") String creator,
                       @RequestParam(value="version") Double version)

    {
        Language language = languageService.findLanguage(id);
        language.setName(name);
        language.setCreator(creator);
        language.setVersion(version);
        return languageService.updateLanguage(language);
    }

    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}
