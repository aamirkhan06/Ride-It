package com.example.RideIt.model;

import com.example.RideIt.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBooking
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String source;
    String destination;
    double tripDistanceInKm;
    double totalFare;

    @Enumerated(EnumType.STRING)
    TripStatus tripStatus;

    @CreationTimestamp
    Date bookAt;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    Driver driver;
}
