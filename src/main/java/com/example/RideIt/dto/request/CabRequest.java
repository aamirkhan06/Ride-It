package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest
{
    String cabNumber;
    CarType carType;
    String carModel;
    String company;
    int numberOfSeats;
    double farePerKm;
}
