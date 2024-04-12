package com.example.RideIt.service;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    public String addCustomer(CustomerRequest customerRequest)
    {
        Customer customer= changeToCustomerEntity(customerRequest);
        customerRepository.save(customer);
        return "customer added successfully";
    }

    private Customer changeToCustomerEntity(CustomerRequest customerRequest)
    {
        Customer customer=new Customer();
        customer.setName(customerRequest.getName());
        customer.setAge(customerRequest.getAge());
        customer.setGender(customerRequest.getGender());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        return customer;
    }
}
