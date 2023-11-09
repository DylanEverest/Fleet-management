package com.fleetmanagement.fleet.DTO.Car;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.CarMileage;

@Component
public class CarMileageDTO 
{
    @Autowired
    CarMileage [] listCarMileage ;    

    @Autowired
    CarMileage carMileage;

    
    String errors ;

    public void setCarMileageAsList(List<CarMileage> list)
    {
        listCarMileage = list.toArray(new CarMileage[list.size()]) ;
    }

    public CarMileage[] getListCarMileage() {
        return listCarMileage;
    }


    public void setListCarMileage(CarMileage[] listCarMileage) {
        this.listCarMileage = listCarMileage;
    }


    public CarMileage getCarMileage() {
        return carMileage;
    }


    public void setCarMileage(CarMileage carMileage) {
        this.carMileage = carMileage;
    }


    public String getErrors() {
        return errors;
    }


    public void setErrors(String errors) {
        this.errors = errors;
    }

 
    
}
