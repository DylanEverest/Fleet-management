package com.fleetmanagement.fleet.DTO.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.Car;

@Component
public class CarDTO 
{
    @Autowired
    Car [] cars ;    

    String errors ;

    public Car[] getCar() {
        return cars;
    }

    public void setCar(Car cars) {
        this.cars[0] = cars;
    }
    public void setCar(Car[] cars) {
        this.cars = cars;
    }
    public void setCar(List<Car> cars) {
        this.cars = cars.toArray(new Car[cars.size()]);
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
    
}
