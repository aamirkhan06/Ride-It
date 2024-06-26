package com.example.RideIt.repository;

import com.example.RideIt.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>
{
    Driver findByMobileNumber(String mobileNumber);
}
