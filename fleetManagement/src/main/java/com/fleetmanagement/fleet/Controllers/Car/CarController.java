package com.fleetmanagement.fleet.Controllers.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.DTO.Car.CarDTO;
import com.fleetmanagement.fleet.Entities.Car;
import com.fleetmanagement.fleet.Services.CRUD.CarCRUDService;


@RestController
@RequestMapping("/fleet")
public class CarController {

    @Autowired
    private CarCRUDService carCRUDService ;

    @Autowired
    private CarDTO carsDTO ;


    @GetMapping(path = "/cars")
    public CarDTO getCars()
    {
        List<Car> cars = carCRUDService.getCarList() ;
        carsDTO.setCar(cars);
        return carsDTO ;
    }

    @GetMapping(path = "/cars/{id}")
    public CarDTO getCarsById(@PathVariable("id") final Long id)
    {
        Car cars = carCRUDService.getCarByID(Long.valueOf(id)) ;
        carsDTO.setCar(cars) ;

        return carsDTO ;
    }

    @PostMapping(path = "/cars")
    public CarDTO saveCar(@RequestBody CarDTO carsDTO)
    {
        carCRUDService.postCar(carsDTO.getCar()[0]);

        return carsDTO;

    }    

    @PutMapping(path ="/cars/{id}")
    public CarDTO updateCar(@PathVariable("id") final Long id , @RequestBody CarDTO carsDTO)
    {
        carCRUDService.updateCar(id, carsDTO.getCar()[0]);

        return carsDTO;
    }

    @DeleteMapping(path = "/cars/{id}")
    public void deleteCar(@PathVariable("id") final Long id)
    {
        carCRUDService.deleteCarByID(id);
    }
}
