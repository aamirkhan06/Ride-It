package com.example.RideIt.model;

import com.example.RideIt.Enum.TripStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TripBooking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId; //uuid
    String pickUp;
    String destination;
    double tripDistanceInKm;
    double totalFare;

    @Enumerated(EnumType.STRING)
    TripStatus tripStatus;

    @CreationTimestamp
    Date bookAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;
}
