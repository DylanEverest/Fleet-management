package com.fleetmanagement.fleet.Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Car 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(nullable = false )
    private String carbrand ;

    @OneToMany(cascade = CascadeType.ALL)
    CarMileage carMileage ;

    public Long getCarId() 
    {
        return carId;
    }

    public void setCarId(Long carId) 
    {
        this.carId = carId;
    }

    public String getCarbrand() 
    {
        return carbrand;
    }

    public void setCarbrand(String carbrand) 
    {
        this.carbrand = carbrand;
    }
    
}
