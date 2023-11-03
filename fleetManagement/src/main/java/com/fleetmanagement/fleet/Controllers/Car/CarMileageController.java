package com.fleetmanagement.fleet.Controllers.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.Entities.CarMileage;
import com.fleetmanagement.fleet.Services.CRUD.CarMileageCRUDService;


@RestController
public class CarMileageController {

    @Autowired
    private CarMileageCRUDService carMileageCRUDService ;

    @GetMapping(path = "/carMileage")
    public Iterable<CarMileage> getCarMileages()
    {
        return carMileageCRUDService.getCarMileageList() ;
    }

    @GetMapping(path = "/carMileage/{id}")
    public CarMileage getCarMileageById(@PathVariable("id") final Long id)
    {
        return carMileageCRUDService.getCarMileageByID(Long.valueOf(id)) ;
    }

    @PostMapping(path = "/carMileage")
    public CarMileage saveCarMileage(@RequestBody CarMileage carMileage)
    {
        return carMileageCRUDService.postCarMileage(carMileage);
    }    

    @PutMapping(path ="/carMileage/{id}")
    public void updateCarMileage(@PathVariable("id") final Long id , @RequestBody CarMileage carMileage)
    {
        carMileageCRUDService.updateCarMileage(id, carMileage);
    }

    @DeleteMapping(path = "/carMileage/{id}")
    public void deleteCarMileage(@PathVariable("id") final Long id)
    {
        carMileageCRUDService.deleteCarMileageByID(id);
    }

    
}
