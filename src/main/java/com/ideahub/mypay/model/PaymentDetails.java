package com.ideahub.mypay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDetails {
    private long counterId;
    private String outletName;
    private double amount;
    private long cardId;
}
