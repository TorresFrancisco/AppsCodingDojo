package com.francisco.repasocinturon.repository;

import com.francisco.repasocinturon.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User>{

    User findByEmail(String email);

    boolean existsByEmail(String email);

}
