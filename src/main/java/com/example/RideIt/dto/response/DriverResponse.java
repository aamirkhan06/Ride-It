package com.example.RideIt.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class DriverResponse
{
    String name;
    double rating;
    String mobileNumber;
    CabResponse cabResponse;
}
