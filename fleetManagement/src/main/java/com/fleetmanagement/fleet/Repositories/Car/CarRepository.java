package com.fleetmanagement.fleet.Repositories.Car;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fleetmanagement.fleet.Entities.Car;

public interface CarRepository extends JpaRepository<Car ,Long>{
    // customed methods
}
