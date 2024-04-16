package com.example.RideIt.service;

import com.example.RideIt.Enum.Gender;
import com.example.RideIt.dto.request.CustomerRequest;
import com.example.RideIt.dto.response.CustomerResponse;
import com.example.RideIt.model.Customer;
import com.example.RideIt.repository.CustomerRepository;
import com.example.RideIt.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<CustomerResponse> getCustomerByGenderAndAgeGreaterThan(Gender gender, int age)
    {
        List<Customer> customers=customerRepository.getCustomerByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponseList=new ArrayList<>();
        for(Customer customer:customers)
        {
            customerResponseList.add(CustomerTransformer.customertoCustomerResponse(customer));
        }
        return  customerResponseList;
    }
}
