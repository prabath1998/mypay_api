package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Counter;
import com.ideahub.mypay.service.CounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/counter")
public class CounterController {
    @Autowired
    private CounterService counterService;

    @PostMapping("/save")
    public ResponseEntity<Counter> saveCounter(@RequestBody Counter counter) {
        Counter newCounter = counterService.saveCounter(counter);
        return new ResponseEntity<>(newCounter, HttpStatus.CREATED);
    }
}
