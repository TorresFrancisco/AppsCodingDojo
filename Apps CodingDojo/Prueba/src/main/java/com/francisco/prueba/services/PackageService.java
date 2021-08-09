package com.francisco.prueba.services;


import com.francisco.prueba.models.Package;
import com.francisco.prueba.repositories.PackageRepository;
import org.springframework.stereotype.Service;

@Service
public class PackageService extends BaseService<Package>{
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository){
        super(packageRepository);
        this.packageRepository = packageRepository;
    }
    public Package findPackage(String name){
        return packageRepository.findByNameContaining(name);
    }

}
