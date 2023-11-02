package com.fleetmanagement.fleet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.User;
import com.fleetmanagement.fleet.Repositories.UserRepository;

@Service

public class UserService {
    
    @Autowired
    private UserRepository userRepository ;


    public List<User> getUserList() 
    {
        return userRepository.findAll();
    }

    public void deleteUserByID(Long id)
    {
        userRepository.deleteById(id);

    }

    public User postUser(User user)
    {
        return userRepository.save(user) ;
    }

    public User getUserByID (Long id)
    {
        try 
        {
            return userRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }

    public void updateUser(Long id ,User user)
    {
        User userToUpdate = getUserByID(id);

        if (userToUpdate == null) return ;

        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setPassword(user.getPassword());

        postUser(userToUpdate) ;

    }

}
