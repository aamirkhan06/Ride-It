package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.CabRequest;
import com.example.RideIt.model.Cab;

public class CabTransformer
{

    public static Cab cabRequestToCab(CabRequest cabRequest)
    {
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .carModel(cabRequest.getCarModel())
                .carType(cabRequest.getCarType())
                .company(cabRequest.getCompany())
                .farePerKm(cabRequest.getFarePerKm())
                .numberOfSeats(cabRequest.getNumberOfSeats())
                .build();
    }
}
