package com.ideahub.mypay.service;

import com.ideahub.mypay.model.Customer;
import com.ideahub.mypay.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long customerId,Customer customer){
        Customer existingCustomer = customerRepository.findById(customerId).get();
        if (existingCustomer != null){
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setContactNo(customer.getContactNo());
            existingCustomer.setDateOfBirth(customer.getDateOfBirth());
            existingCustomer.setNicNumber(customer.getNicNumber());
        }
        return customerRepository.save(existingCustomer);
    }
}
