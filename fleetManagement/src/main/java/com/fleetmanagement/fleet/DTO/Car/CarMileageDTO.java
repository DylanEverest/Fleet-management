package com.fleetmanagement.fleet.DTO.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Entities.CarMileage;

@Component
public class CarMileageDTO 
{
    @Autowired
    CarMileage [] carsMileage ;    

    String errors ;

    public CarMileage[] getCarMileage() {
        return carsMileage;
    }

    public void setCarMileage(CarMileage carsMileage) {
        this.carsMileage[0] = carsMileage;
    }
    public void setCarMileage(CarMileage[] carsMileage) {
        this.carsMileage = carsMileage;
    }
    public void setCarMileage(List<CarMileage> carsMileage) {
        this.carsMileage = carsMileage.toArray(new CarMileage[carsMileage.size()]);
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
    
}
