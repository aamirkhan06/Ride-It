package com.example.RideIt.repository;

import com.example.RideIt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    //hibernate implements the jpa repository
}
