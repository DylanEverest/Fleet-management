package com.fleetmanagement.fleet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.Car;
import com.fleetmanagement.fleet.Repositories.CarRepository;

@Service
public class CarService 
{

    @Autowired
    private CarRepository carRepository;

    
    public List<Car> getCarList() 
    {
        return carRepository.findAll();
    }

    public void deleteCarByID(Long id)
    {
        carRepository.deleteById(id);

    }

    public Car postCar(Car car)
    {
        return carRepository.save(car) ;
    }

    public Car getCarByID (Long id)
    {
        return carRepository.getReferenceById(id);
    }


}
