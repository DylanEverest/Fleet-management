package com.fleetmanagement.fleet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fleetmanagement.fleet.Entities.Car;
import com.fleetmanagement.fleet.Services.BusinessHelloService;
import com.fleetmanagement.fleet.Services.CarService;

@SpringBootTest
class FleetApplicationTests {

	@Autowired
	BusinessHelloService businessHelloService ;

	@Autowired
	CarService carService ;


	@Test
	void contextLoads() {
	}

	@Test
	public void testHello()
	{
		String response = businessHelloService.getHelloWorld().toString();

		assertEquals("Hello World!", response);
	}

	@Test 
	public void testGetCarList()
	{
		System.out.println(carService.getCarList().size());
	}

	@Test 
	public void testGetCarByID()
	{
		System.out.println(carService.getCarByID( Long.valueOf(1)) ) ;
	}

	@Test
	public void deleteCarById()
	{
		carService.deleteCarByID( Long.valueOf(3)) ;
		carService.getCarByID( Long.valueOf(3)) ;
	}

	@Test void insert()
	{
		Car car = new Car();
		car.setCarbrand("NISSAN");

		carService.postCar(car) ;

	}

	@Test void updateCar()
	{
		Car car = new Car() ;
		car.setCarbrand("NISSAN");
		carService.updateCar(Long.valueOf(3), car);
	}

}
