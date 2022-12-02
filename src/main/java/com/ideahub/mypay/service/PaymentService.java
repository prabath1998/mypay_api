package com.ideahub.mypay.service;

import com.ideahub.mypay.model.*;
import com.ideahub.mypay.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;



    public Payment makePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments(){
        List<Payment> allPayments = paymentRepository.findAll();
        return allPayments;
    }

    public Payment getPaymentById(Long paymentId){
        return paymentRepository.findById(paymentId).get();
    }


}
