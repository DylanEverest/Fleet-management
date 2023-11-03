package com.fleetmanagement.fleet.Controllers.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.Entities.Car;
import com.fleetmanagement.fleet.Services.CRUD.CarCRUDService;


@RestController
public class CarController {

    @Autowired
    private CarCRUDService carCRUDService ;

    @GetMapping(path = "/car")
    public Iterable<Car> getCars()
    {
        return carCRUDService.getCarList() ;
    }

    @GetMapping(path = "/car/{id}")
    public Car getCarsById(@PathVariable("id") final Long id)
    {
        return carCRUDService.getCarByID(Long.valueOf(id)) ;
    }

    @PostMapping(path = "/car")
    public Car saveCar(@RequestBody Car car)
    {
        return carCRUDService.postCar(car);
    }    

    @PutMapping(path ="/car/{id}")
    public void updateCar(@PathVariable("id") final Long id , @RequestBody Car car)
    {
        carCRUDService.updateCar(id, car);
    }

    @DeleteMapping(path = "/car/{id}")
    public void deleteCar(@PathVariable("id") final Long id)
    {
        carCRUDService.deleteCarByID(id);
    }
}
