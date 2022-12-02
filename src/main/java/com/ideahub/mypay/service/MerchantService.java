package com.ideahub.mypay.service;

import com.ideahub.mypay.model.Merchant;
import com.ideahub.mypay.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Autowired
    private MerchantRepository merchantRepository;

    public Merchant saveMerchant(Merchant merchant){
        return merchantRepository.save(merchant);
    }
}
