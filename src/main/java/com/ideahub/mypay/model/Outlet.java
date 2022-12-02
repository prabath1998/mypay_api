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
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long outletId;
    private String outletName;
    @ManyToOne
    private Merchant merchant;
}
