package com.fleetmanagement.fleet.Controllers.Car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fleetmanagement.fleet.DTO.Car.CarMileageDTO;
import com.fleetmanagement.fleet.Entities.CarMileage;
import com.fleetmanagement.fleet.Services.CRUD.CarMileageCRUDService;


@RestController
@RequestMapping("/fleet")
public class CarMileageController {

    @Autowired
    private CarMileageCRUDService carMileageCRUDService ;

    @Autowired
    private CarMileageDTO carMileagesDTO ;


    @GetMapping(path = "/carMileages")
    public CarMileageDTO getCarMileages()
    {
        List<CarMileage> carMileages = carMileageCRUDService.getCarMileageList() ;
        carMileagesDTO.setCarMileageAsList(carMileages);
        return carMileagesDTO ;
    }

    @GetMapping(path = "/carMileages/{id}")
    public CarMileageDTO getCarMileagesById(@PathVariable("id") final Long id)
    {
        CarMileage carMileages = carMileageCRUDService.getCarMileageByID(Long.valueOf(id)) ;
        carMileagesDTO.setCarMileage(carMileages) ;

        return carMileagesDTO ;
    }

    @PostMapping(path = "/carMileages")
    public CarMileageDTO saveCarMileage(@RequestBody CarMileageDTO carMileagesDTO)
    {
        carMileageCRUDService.postCarMileage(carMileagesDTO.getCarMileage());

        return carMileagesDTO;

    }    

    @PutMapping(path ="/carMileages/{id}")
    public CarMileageDTO updateCarMileage(@PathVariable("id") final Long id , @RequestBody CarMileageDTO carMileagesDTO)
    {
        carMileageCRUDService.updateCarMileage(id, carMileagesDTO.getCarMileage());

        return carMileagesDTO;
    }

    @DeleteMapping(path = "/carMileages/{id}")
    public void deleteCarMileage(@PathVariable("id") final Long id)
    {
        carMileageCRUDService.deleteCarMileageByID(id);
    }

    
}
