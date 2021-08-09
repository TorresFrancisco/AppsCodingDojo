package com.francisco.repasocinturon.services;

import com.francisco.repasocinturon.models.User;
import com.francisco.repasocinturon.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService<User>{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        super(userRepository);
        this.userRepository = userRepository;
    }

    // registrar el usuario y hacer Hash a su password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }

    // encontrar un usuario por su email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // autenticar usuario
    public boolean authenticateUser(String email, String password) {
        // primero encontrar el usuario por su email
        User user = userRepository.findByEmail(email);
        // si no lo podemos encontrar por su email, retornamos false
        if(user == null) {
            return false;
        } else {
            // si el password coincide devolvemos true, sino, devolvemos false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean emailExist(String email){
        return userRepository.existsByEmail(email);
    }
}
