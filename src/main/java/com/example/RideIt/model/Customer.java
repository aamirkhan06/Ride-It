package com.example.RideIt.model;

import com.example.RideIt.Enum.Gender;
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
@Table(name="customer") // to name the database of your class for good practise
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
    int age;

    @Column(unique = true,nullable = false)
    String email;

    String address;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<TripBooking> bookings=new ArrayList<>();
}
