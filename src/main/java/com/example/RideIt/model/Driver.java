package com.example.RideIt.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="driver")
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;

    @Column(unique = true,nullable = false)
    String mobileNumber;

    String panNumber;
    double rating;

    //mappedBy will tell  hibernate that it already a foreign key of 'driver' in cab table
    //  cascade is defined as if we do some operation on parent then it should also reflect in child
    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<TripBooking> bookings=new ArrayList<>();
}
