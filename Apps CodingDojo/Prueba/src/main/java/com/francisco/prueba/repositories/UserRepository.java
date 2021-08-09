package com.francisco.prueba.repositories;

import com.francisco.prueba.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>{

    User findByEmail(String email);

    boolean existsByEmail(String email);

}