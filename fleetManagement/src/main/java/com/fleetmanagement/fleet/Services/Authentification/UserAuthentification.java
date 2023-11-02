package com.fleetmanagement.fleet.Services.Authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User;
import com.fleetmanagement.fleet.Repositories.UserRepository;


@Service
public class UserAuthentification 
{
    @Autowired
    private UserRepository userRepository ;

    public boolean doExist(User user)
    {
        User found = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        
        return found != null ;

    }
    

    
}
