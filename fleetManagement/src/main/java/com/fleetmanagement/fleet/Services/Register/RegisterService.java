package com.fleetmanagement.fleet.Services.Register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Entities.User.UserException;
import com.fleetmanagement.fleet.Repositories.User.UserRepository;
import com.fleetmanagement.fleet.Security.Encoder.SHA256PasswordEncoder;

@Component
public class RegisterService 
{

    @Autowired
    private SHA256PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) throws RegisterException, UserException 
    {
        if (userRepository.existsByUserName(user.getUserName())) 
        {
            throw new RegisterException("Username is taken!") ;
        }

        // Encode the passwd
        String encodedPassword = passwordEncoder.encodePassword(user.getPassword());

        user.setPassword(encodedPassword);

        user.setRoles(Double.valueOf(1) );

        userRepository.save(user);
    }

}
    

