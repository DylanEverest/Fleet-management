package com.fleetmanagement.fleet.Services.Authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;


@Service
public class UserAuthentification 
{
    @Autowired
    private UserRepository userRepository ;

    public User login(User user)
    {
        User found = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        
        return found ;

    }
    

    
}
