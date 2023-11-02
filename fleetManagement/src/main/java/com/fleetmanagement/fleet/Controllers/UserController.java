package com.fleetmanagement.fleet.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.Entities.User;
import com.fleetmanagement.fleet.Services.CRUD.UserCRUDService;


@RestController
public class UserController {

    @Autowired
    private UserCRUDService userCRUDService ;

    @GetMapping(path = "/user")
    public Iterable<User> getUsers()
    {
        return userCRUDService.getUserList() ;
    }

    @PostMapping(path = "/user")
    public User saveUser(@RequestBody User user)
    {
        return userCRUDService.postUser(user);
    }    

    @PutMapping(path ="/user/{id}")
    public void updateUser(@PathVariable("id") final Long id , @RequestBody User user)
    {
        userCRUDService.updateUser(id, user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable("id") final Long id)
    {
        userCRUDService.deleteUserByID(id);
    }
    
}
