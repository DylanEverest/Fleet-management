package com.fleetmanagement.fleet.Services.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;

@Component
public class RegisterService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        // Encode the passwd
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        // register
        userRepository.save(user);
    }

    public boolean isPasswordValid(User user, String rawPassword) {
        
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
    

