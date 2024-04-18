package com.example.RideIt.model;

import com.example.RideIt.Enum.CarType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="cab")
@Builder
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    CarType carType;

    @Column(unique = true, nullable = false)
    String cabNumber;

    boolean available; //additional parameter
    String carModel;
    String company;
    int numberOfSeats;
    double farePerKm;

    @OneToOne
    @JoinColumn //create a foreign key of driver
    @JsonIgnore
    Driver driver;
}
