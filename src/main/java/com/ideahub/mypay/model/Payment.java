package com.ideahub.mypay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    private LocalDate paymentDate;
    private double amount;
    @ManyToOne()
    private Counter counter;
    @ManyToOne()
    private Card card;



}
