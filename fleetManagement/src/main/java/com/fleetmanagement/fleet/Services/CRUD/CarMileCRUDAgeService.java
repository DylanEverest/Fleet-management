package com.fleetmanagement.fleet.Services.CRUD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetmanagement.fleet.Entities.CarMileage;
import com.fleetmanagement.fleet.Repositories.CarMileageRepository;

@Service
public class CarMileCRUDAgeService 
{

    @Autowired
    CarMileageRepository carMileageRepository ;


    public List<CarMileage> getCarMileageList() 
    {
        return carMileageRepository.findAll();
    }

    public void deleteCarMileageByID(Long id)
    {
        carMileageRepository.deleteById(id);
    }

    public void updateCarMileage(Long id , CarMileage newVal)
    {
        CarMileage carMileageToUpdate = getCarMileageByID(id) ;
        if(carMileageToUpdate == null) return ;

        carMileageToUpdate.setArrivalKm(newVal.getArrivalKm());
        carMileageToUpdate.setCar(newVal.getCar());
        carMileageToUpdate.setDepartureKm(newVal.getDepartureKm());

        postCarMileage(carMileageToUpdate);
    }

    public CarMileage postCarMileage(CarMileage CarMileage)
    {
        return carMileageRepository.save(CarMileage) ;
    }

    public CarMileage getCarMileageByID (Long id)
    {
        try 
        {
            return carMileageRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }

}
