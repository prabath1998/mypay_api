package com.ideahub.mypay;

import com.ideahub.mypay.config.OTPConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyPayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPayApiApplication.class, args);
	}

	@Autowired
	private OTPConfig twilioConfig;
	@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}

}
