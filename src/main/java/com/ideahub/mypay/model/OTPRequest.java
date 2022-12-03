package com.ideahub.mypay.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OTPRequest {
    private String phoneNumber;
    private String userName;
    private String oneTimePassword;
}
