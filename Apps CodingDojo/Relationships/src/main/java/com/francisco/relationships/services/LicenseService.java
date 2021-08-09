package com.francisco.relationships.services;

import com.francisco.relationships.models.License;
import com.francisco.relationships.repository.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository){
        this.licenseRepository = licenseRepository;
    }
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }
    public License createLicense(License b) {
        return licenseRepository.save(b);
    }
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()){
            return optionalLicense.get();
        } else {
            return null;
        }
    }
}
