package com.fleetmanagement.fleet.Controllers.User;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.DTO.User.UserDTO;
import com.fleetmanagement.fleet.Entities.User.User;
import com.fleetmanagement.fleet.Services.CRUD.UserCRUDService;


@RestController
@RequestMapping("/fleet")
public class UserController {

    @Autowired
    private UserCRUDService userCRUDService ;

    @Autowired
    private UserDTO usersDTO ;


    @GetMapping(path = "/users")
    public UserDTO getUsers()
    {
        List<User> users = userCRUDService.getUserList() ;
        usersDTO.setUsersAsList(users);
        return usersDTO ;
    }

    @GetMapping(path = "/users/{id}")
    public UserDTO getUsersById(@PathVariable("id") final Long id)
    {
        User users = userCRUDService.getUserByID(Long.valueOf(id)) ;
        usersDTO.setUsersAsSingle(users) ;

        return usersDTO ;
    }

    @PostMapping(path = "/users")
    public UserDTO saveUser(@RequestBody UserDTO usersDTO)
    {
        userCRUDService.postUser(usersDTO.getUser()[0]);

        return usersDTO;

    }    

    @PutMapping(path ="/users/{id}")
    public UserDTO updateUser(@PathVariable("id") final Long id , @RequestBody UserDTO usersDTO)
    {
        userCRUDService.updateUser(id, usersDTO.getUser()[0]);

        return usersDTO;
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable("id") final Long id)
    {
        userCRUDService.deleteUserByID(id);
    }
    
}
