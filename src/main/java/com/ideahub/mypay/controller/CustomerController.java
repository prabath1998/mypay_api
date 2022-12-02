package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Customer;
import com.ideahub.mypay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer/save")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/customer/update/{id}")
    public Customer updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }
}
