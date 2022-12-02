package com.ideahub.mypay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cardId;
    private String cardHolderName;
    @Column(length = 16)
    private String cardNumber;
    private int cardCsv;
    private Date expirationDate;
    @ManyToOne
    private Customer customer;
}
