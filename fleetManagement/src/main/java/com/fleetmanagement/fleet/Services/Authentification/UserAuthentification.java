package com.fleetmanagement.fleet.Services.Authentification;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;


@Service
public class UserAuthentification 
{
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User login(User user) throws LoginException
    {
        Optional <User> found = userRepository.findByEmail(user.getEmail());
        
        try 
        {
            if (isPasswordValid(user, found.get().getPassword()) ) 
            {
                return found.get();
            }
            else
            {
                throw new LoginException("Invalid credentials");
            }
            
        } 
        catch (Exception e) {
            throw new LoginException("Invalid credentials");
        }
        


    }
    

    public boolean isPasswordValid(User user, String rawPassword) {
        
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
    
}
