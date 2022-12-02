package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Outlet;
import com.ideahub.mypay.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/outlet")
public class OutletController {
    @Autowired
    private OutletService outletService;

    @PostMapping("/save")
    public ResponseEntity<Outlet> saveOutlet(@RequestBody Outlet outlet){
        Outlet newOutlet = outletService.saveOutlet(outlet);
        return new ResponseEntity<>(newOutlet, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public Outlet getOutletById(@PathVariable("id") Long id) {
        return outletService.getOutletById(id);
    }
}
