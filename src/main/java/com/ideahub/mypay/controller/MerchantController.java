package com.ideahub.mypay.controller;

import com.ideahub.mypay.model.Merchant;
import com.ideahub.mypay.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    @Autowired
    private MerchantService merchantService;

    @PostMapping("/save")
    public ResponseEntity<Merchant> saveMerchant(@RequestBody Merchant merchant){
        Merchant newMerchant = merchantService.saveMerchant(merchant);
        return new ResponseEntity<>(newMerchant, HttpStatus.CREATED);
    }
}
