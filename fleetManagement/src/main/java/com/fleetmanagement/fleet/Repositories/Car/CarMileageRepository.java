package com.fleetmanagement.fleet.Repositories.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleetmanagement.fleet.Entities.CarMileage;

public interface CarMileageRepository extends JpaRepository<CarMileage, Long>{
    
}
