package com.francisco.prueba.repositories;

import com.francisco.prueba.models.Package;
import org.springframework.stereotype.Repository;


@Repository
public interface PackageRepository extends BaseRepository<Package>{

    Package findByNameContaining(String name);
}
