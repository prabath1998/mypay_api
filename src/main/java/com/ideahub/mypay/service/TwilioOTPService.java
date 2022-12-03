package com.ideahub.mypay.service;

import com.ideahub.mypay.config.OTPConfig;
import com.ideahub.mypay.model.OTPRequest;
import com.ideahub.mypay.model.OTPResponse;
import com.ideahub.mypay.model.OTPStatus;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TwilioOTPService {
    @Autowired
    private OTPConfig twilioConfig;

    Map<String,String> otpMap = new HashMap<>();
    public Mono<OTPResponse> sendOtpToUser(OTPRequest otpDto){
        OTPResponse otpResponse = null;
        try {
            PhoneNumber to = new PhoneNumber(otpDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String generatedOtp = generateOtp();
            String otpMessage = "Dear Customer , Your OTP is ##" + generatedOtp + "##. Use this Passcode to complete your transaction. Thank You.";
            Message message = Message
                    .creator(to, from,
                            otpMessage)
                    .create();
            otpMap.put(otpDto.getUserName(),generatedOtp);
            otpResponse = new OTPResponse(OTPStatus.DELIVERED,otpMessage);
        }catch (Exception e){
            otpResponse = new OTPResponse(OTPStatus.FAILED,e.getMessage());
        }
        return Mono.just(otpResponse);
    }

    //6 digit OTP
    private String generateOtp(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }

    public Mono<String> validateOTP(String userInputOtp,String userName){
        if (userInputOtp.equals(otpMap.get(userName))){
            return Mono.just("Valid OTP");
        }else {
            return Mono.error(new IllegalArgumentException("Invalid OTP"));
        }
    }
}
