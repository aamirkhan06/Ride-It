package com.example.RideIt.dto.response;

import com.example.RideIt.Enum.CarType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CabResponse
{
    String cabNumber;
    String carModel;
    double farePerKm;
    boolean available;
}
