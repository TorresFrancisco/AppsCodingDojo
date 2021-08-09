package com.francisco.relationships.controllers;

import com.francisco.relationships.models.License;
import com.francisco.relationships.models.Person;
import com.francisco.relationships.services.LicenseService;
import com.francisco.relationships.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LicenseController {
    private final LicenseService licenseService;
    private final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }

    @GetMapping("licenses/new")
    public String newLicense(
            @ModelAttribute("license") License license, Model model ){
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        model.addAttribute("license", license);
        return "newLicense.jsp";
    }

    @PostMapping("licenses/new")
    public String addLicense(
            @Valid
            @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "newLicense.jsp";
        } else {
            licenseService.createLicense(license);
            Long idLicense1 = license.getId();
            String format = String.format("%06d", idLicense1);
            license.setNumber(format);
            licenseService.createLicense(license);
            return "redirect:/persons/"+license.getPerson().getId();
        }
    }
}