package com.example.RideIt.service;

import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse addCustomer(CustomerRequest customerRequest)
    {
        //using builder to create objects(request dto->entity)
        Customer customer= CustomerTransformer.customerRequestToCustomer(customerRequest);

        Customer savedCustomer=customerRepository.save(customer);

        //using builder to create objects(entity->request dto)
        return CustomerTransformer.customertoCustomerResponse(savedCustomer);
    }
}
