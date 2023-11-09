package com.fleetmanagement.fleet.DTO.User;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.User.User;

@Component
public class UserDTO 
{
    @Autowired
    User [] listUser ;    

    @Autowired
    User user;

    String errors ;

    public void setUsersAsList(List<User> list)
    {
        listUser = list.toArray(new User[list.size()]) ;
    }
    
    public User[] getListUser() {
        return listUser;
    }

    public void setListUser(User[] listUser) {
        this.listUser = listUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }



}
