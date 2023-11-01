package com.fleetmanagement.fleet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fleetmanagement.fleet.Services.BusinessHelloService;

@SpringBootApplication
public class FleetApplication implements CommandLineRunner{

	@Autowired
	BusinessHelloService businessHelloService ;

	public static void main(String[] args) {
		SpringApplication.run(FleetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		System.out.println(businessHelloService.getHelloWorld().toString());
	}

}
