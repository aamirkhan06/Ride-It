package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.DriverRequest;
import com.example.RideIt.model.Cab;
import com.example.RideIt.model.Driver;

public class DriverTransformer
{
    public static Driver driverRequestToDriver(DriverRequest driverRequest)
    {
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobileNumber(driverRequest.getMobileNumber())
                .panNumber(driverRequest.getPanNumber())
                .build();
    }
}
