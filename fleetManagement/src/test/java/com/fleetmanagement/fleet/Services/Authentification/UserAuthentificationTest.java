package com.fleetmanagement.fleet.Services.Authentification;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fleetmanagement.fleet.Entities.User.User;

@SpringBootTest
public class UserAuthentificationTest {

    @Autowired
    UserAuthentification userAuthentification ;


    @Test
	void contextLoads() {
	}

    @Test
    void testDoExist() {
        User user = new User() ;
        user.setEmail("dylan@gmail.com");
        user.setPassword("SAMBO");

        System.out.println(userAuthentification.doExist(user));
    }
}
