package com.ideahub.mypay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Counter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long counterId;
    private int counterNo;
    @ManyToOne
    private Outlet outlet;
}
