package com.fleetmanagement.fleet.Services.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.Car;
import com.fleetmanagement.fleet.Repositories.Car.CarRepository;

@Service
public class CarCRUDService 
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
        try 
        {
            return carRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }

    public void updateCar(Long id , Car car)
    {
        Car carToUpdate = getCarByID(id) ;
        if(carToUpdate == null) return;

        carToUpdate.setCarbrand(car.getCarbrand());

        postCar(carToUpdate) ;
    }

}
