package com.fleetmanagement.fleet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fleetmanagement.fleet.Entities.CarMileage;
import com.fleetmanagement.fleet.Services.CarMileAgeService;

@SpringBootTest
public class CarMileageTests 
{
    @Autowired
    CarMileAgeService carMileAgeService ;


	@Test
	void contextLoads() {
	}
    

    @Test 
	public void testGetCarMileageList()
	{
		System.out.println(carMileAgeService.getCarMileageList().size());
	}

	@Test 
	public void testGetCarMileageByID()
	{
		System.out.println(carMileAgeService.getCarMileageByID( Long.valueOf(1)) ) ;
	}

	@Test
	public void deleteCarMileageById()
	{
		carMileAgeService.deleteCarMileageByID( Long.valueOf(1)) ;
		carMileAgeService.getCarMileageByID( Long.valueOf(1)) ;
	}

	@Test void insert()
	{

        CarMileage carMileage = new CarMileage();
        carMileage.setArrivalKm(140);
        carMileage.setDepartureKm(8);
        
		carMileAgeService.postCarMileage(carMileage) ;

	}
}
