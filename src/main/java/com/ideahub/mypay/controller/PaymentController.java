package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Payment;
import com.ideahub.mypay.model.PaymentDetails;
import com.ideahub.mypay.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<String> makePayment(@RequestBody Payment payment){
        paymentService.makePayment(payment);
        return ResponseEntity.status(HttpStatus.OK).body("Payment Successful!");
    }
    @GetMapping("/get/all")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/get/{id}")
    public Payment getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }


}
