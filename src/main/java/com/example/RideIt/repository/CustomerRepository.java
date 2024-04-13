package com.example.RideIt.repository;

import com.example.RideIt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    //hibernate implements the jpa repository
}
