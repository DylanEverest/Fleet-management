package com.fleetmanagement.fleet;

// import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// import com.fleetmanagement.fleet.Entities.CarMileage;
import com.fleetmanagement.fleet.Services.CRUD.CarCRUDService;
import com.fleetmanagement.fleet.Services.CRUD.CarMileageCRUDService;

@SpringBootTest
public class CarMileageTests 
{
    @Autowired
    CarMileageCRUDService carMileAgeService ;

    @Autowired
    CarCRUDService carService ;

	@Test
	void contextLoads() {
	}
    

    // @Test 
	// public void testGetCarMileageList()
	// {
    //     List<CarMileage> list = carMileAgeService.getCarMileageList() ;
	// 	System.out.println(list.size());
	// }

	// @Test 
	// public void testGetCarMileageByID()
	// {
	// 	System.out.println(carMileAgeService.getCarMileageByID( Long.valueOf(6)) ) ;
	// }

	// @Test
	// public void deleteCarMileageById()
	// {
	// 	carMileAgeService.deleteCarMileageByID( Long.valueOf(4)) ;
	// 	// System.out.println(carMileAgeService.getCarMileageByID( Long.valueOf(1)).getArrivalKm() ) ;
	// }

	// @Test 
    // public void insert()
	// {

    //     CarMileage carMileage = new CarMileage();
    //     carMileage.setArrivalKm(140);
    //     carMileage.setDepartureKm(8);
    //     carMileage.setCar(carService.getCarByID(Long.valueOf(3) ));
        
	// 	carMileAgeService.postCarMileage(carMileage) ;

	// }


    // @Test
    // public void update()
    // {
    //     CarMileage carMileage = new CarMileage();
    //     carMileage.setArrivalKm(140);
    //     carMileage.setDepartureKm(0);
    //     carMileage.setCar(carService.getCarByID(Long.valueOf(3) ));

    //     carMileAgeService.updateCarMileage(Long.valueOf(6), carMileage);
    // }
}
