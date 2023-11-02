package com.fleetmanagement.fleet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fleetmanagement.fleet.Entities.User;
import com.fleetmanagement.fleet.Services.UserService;

@SpringBootTest
public class UserApplicationTests {

    @Autowired
    UserService userService ;


	@Test
	void contextLoads() {
	}
	@Test 
	public void testGetUserList()
	{
		System.out.println(userService.getUserList().size());
	}

	@Test 
	public void testGetUserByID()
	{
		System.out.println(userService.getUserByID( Long.valueOf(1)) ) ;
	}

	@Test
	public void deleteUserById()
	{
		userService.deleteUserByID( Long.valueOf(1)) ;
		userService.getUserByID( Long.valueOf(1)) ;
	}

	@Test void insert()
	{
		User user = new User();
        user.setEmail("dylan@gmail.com");
        user.setPassword("ALICE");
        user.setUserName("Dylan");

		userService.postUser(user) ;

	}

	@Test void update()
	{
		User user = new User();
        user.setEmail("dylan@gmail.com");
        user.setPassword("SAMBO");
        user.setUserName("Dylan");
		userService.updateUser(Long.valueOf(2), user);
	}
    
}
