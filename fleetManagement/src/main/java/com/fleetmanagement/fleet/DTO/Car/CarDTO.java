package com.fleetmanagement.fleet.DTO.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.Car;

@Component
public class CarDTO 
{
    @Autowired
    Car [] listCars ;    

    @Autowired
    Car car;

    String errors ;

    public Car[] getListCars() {
        return listCars;
    }

    public void setListCars(Car[] listCars) {
        this.listCars = listCars;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }


    
}
