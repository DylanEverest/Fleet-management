package com.fleetmanagement.fleet.DTO.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.User.User;

@Component
public class UserDTO 
{
    @Autowired
    User [] users ;    

    String errors ;

    public User[] getUser() {
        return users;
    }

    public void setUser(User users) {
        this.users[0] = users;
    }
    public void setUser(User[] users) {
        this.users = users;
    }
    public void setUser(List<User> users) {
        this.users = users.toArray(new User[users.size()]);
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
