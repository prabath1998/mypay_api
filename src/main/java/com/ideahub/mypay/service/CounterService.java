package com.ideahub.mypay.service;

import com.ideahub.mypay.model.Counter;
import com.ideahub.mypay.repository.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    @Autowired
    private CounterRepository counterRepository;

    public Counter saveCounter(Counter counter){
        return counterRepository.save(counter);
    }
}
