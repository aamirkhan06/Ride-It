package com.example.RideIt.dto.response;

import com.example.RideIt.Enum.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBookingResponse
{
    String bookingId; //uuid
    String pickUp;
    String destination;
    double tripDistanceInKm;
    double totalFare;
    TripStatus tripStatus;
    Date bookAt;
    CustomerResponse customerResponse;
    DriverResponse driverResponse;
}
