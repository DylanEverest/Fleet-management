package com.fleetmanagement.fleet.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userApp")
public class User 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserID ;

    @Column(length = 50  ,nullable = false)
    private String UserName ;

    @Column(length = 250 ,nullable = false)
    private String password;

    @Column(length = 250 ,nullable = false)
    private String email;

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
        return UserName;
    }

    public void setUserName(String userName) 
    {
        UserName = userName;
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
    
}
