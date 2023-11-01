package com.fleetmanagement.fleet.Services;

import org.springframework.stereotype.Component;

import com.fleetmanagement.fleet.Models.HelloWorld;

@Component
public class BusinessHelloService {

    public HelloWorld getHelloWorld()
    {
        HelloWorld world = new HelloWorld();
        return world;
    }

}
