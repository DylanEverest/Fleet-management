package com.fleetmanagement.fleet.Services.Authentification;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;
import com.fleetmanagement.fleet.Security.Encoder.SHA256PasswordEncoder;


@Service
public class UserAuthentification 
{
    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private SHA256PasswordEncoder passwordEncoder;


    public User login(User user) throws LoginException
    {
        Optional <User> found = userRepository.findByEmail(user.getEmail());
        
        try 
        {
            if (passwordEncoder.matches(user.getPassword(), found.get().getPassword()) ) 
            {
                return found.get();
            }
            else
            {
                System.out.println("ATO e");
                throw new LoginException("Invalid credentials");
            }
            
        } 
        catch (Exception e) {
            throw new LoginException("Invalid credentials");
        }
        


    }
    


    
}
