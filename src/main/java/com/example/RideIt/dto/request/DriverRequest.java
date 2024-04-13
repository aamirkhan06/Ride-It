package com.example.RideIt.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest
{
    String name;
    int age;
    String panNumber;
    String mobileNumber;
    CabRequest cab;
}
