package com.fleetmanagement.fleet.Entities.User;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "userApp")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID ;

    @Column(length = 50  ,nullable = false)
    private String userName ;

    @Column(length = 250 ,nullable = false)
    private String password;

    @Column(length = 250 ,nullable = false)
    private String email;

    @ManyToMany( fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Roles> roles ;


    public Long getUserID() 
    {
        return UserID;
    }

    public void setUserID(Long userID) 
    {
        UserID = userID;
    }

    public String getUserName() 
    {
        return userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
    
}
