package com.ideahub.mypay.service;

import com.ideahub.mypay.model.Outlet;
import com.ideahub.mypay.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutletService {
    @Autowired
    private OutletRepository outletRepository;

    public Outlet saveOutlet(Outlet outlet){
        return outletRepository.save(outlet);
    }

    public Outlet getOutletById(Long outletId){
        return outletRepository.findById(outletId).get();
    }
}
