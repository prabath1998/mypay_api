package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Customer;
import com.ideahub.mypay.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer newCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
        Customer updatedCustomer = customerService.updateCustomer(id,customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
}
