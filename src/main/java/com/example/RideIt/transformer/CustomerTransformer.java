package com.example.RideIt.transformer;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;

public class CustomerTransformer
{
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest)
    {
        Customer customer=Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .build();
        return customer;
    }

    public static CustomerResponse customertoCustomerResponse(Customer customer)
    {
        CustomerResponse customerResponse=CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
        return customerResponse;
    }
}
