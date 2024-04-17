package com.example.RideIt.dto.request;

import com.example.RideIt.Enum.TripStatus;
import com.example.RideIt.model.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingRequest
{
    String pickUp;
    String destination;
    double tripDistanceInKm;
    String customerEmail;
    //driver and trip status
    // will be handled from backend
}
