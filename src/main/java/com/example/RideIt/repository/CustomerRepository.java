package com.example.RideIt.repository;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
    //hibernate implements the jpa repository

    //sql query: according in terms of database entities

//    @Query(value = "select * from customer where gender =:gender and age>=:age", nativeQuery = true)
//    List<Customer> getCustomerByGenderAndAge(String gender, int age);

    //HQL query: according in terms of java entities
    @Query(value = "select c from Customer c where c.gender =:gender and c.age>=:age")
    List<Customer> getCustomerByGenderAndAge(Gender gender, int age);

    Customer findByEmail(String email);
}
