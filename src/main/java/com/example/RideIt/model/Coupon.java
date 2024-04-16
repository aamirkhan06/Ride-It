package com.example.RideIt.model;

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
@Table(name="coupon")
@Builder
public class Coupon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String couponCode;
    int percentageDiscount;
}
