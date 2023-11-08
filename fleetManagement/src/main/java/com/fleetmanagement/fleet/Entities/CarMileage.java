package com.fleetmanagement.fleet.Entities;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "carMileage")
public class CarMileage 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long carMileageId ;

    @CreationTimestamp
    private Timestamp createdDate ;

    @Column(nullable = false)
    private double departureKm ;

    private double arrivalKm ;

    @ManyToOne(fetch = FetchType.EAGER ,optional = false )
    private Car car ;



    public Car getCar() 
    {
        return car;
    }

    public void setCar(Car car) 
    {
        this.car = car;
    }

    public Long getCarMileageId() 
    {
        return carMileageId;
    }

    public void setCarMileageId(Long carMileageId) 
    {
        this.carMileageId = carMileageId;
    }

    public Timestamp getCreatedDate() 
    {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) 
    {
        this.createdDate = createdDate;
    }

    public double getDepartureKm() 
    {
        return departureKm;
    }

    public void setDepartureKm(double departureKm) 
    {
        this.departureKm = departureKm;
    }

    public double getArrivalKm() 
    {
        return arrivalKm;
    }

    public void setArrivalKm(double arrivalKm) 
    {
        this.arrivalKm = arrivalKm;
    }


}