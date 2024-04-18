package com.example.RideIt.service;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;
import com.example.RideIt.repository.DriverRepository;
import com.example.RideIt.transformer.CabTransformer;
import com.example.RideIt.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService
{
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public String addDriver(DriverRequest driverRequest)
    {
        //driverRequest to driver
        Driver driver=DriverTransformer.driverRequestToDriver(driverRequest);

        //cabRequest to cab
        Cab cab= CabTransformer.cabRequestToCab(driverRequest.getCab());

        //set the relationship attribute
        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver); //the cab will also be saved successfully
        return "Driver added successfully";
    }

    public Driver getDriver(String mobNo)
    {
        return driverRepository.findByMobileNumber(mobNo);
    }

    //delete a driver by phone number
}
