package com.ideahub.mypay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTPResponse {
    private OTPStatus status;
    private String message;
}
