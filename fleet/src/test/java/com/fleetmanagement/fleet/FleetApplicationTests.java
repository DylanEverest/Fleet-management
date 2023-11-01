package com.fleetmanagement.fleet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fleetmanagement.fleet.Services.BusinessHelloService;

@SpringBootTest
class FleetApplicationTests {

	@Autowired
	BusinessHelloService businessHelloService ;

	@Test
	void contextLoads() {
	}

	@Test
	public void testHello()
	{
		String response = businessHelloService.getHelloWorld().toString();

		assertEquals("Hello World!", response);
	}

}
