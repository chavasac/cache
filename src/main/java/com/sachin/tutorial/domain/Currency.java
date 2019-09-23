package com.sachin.tutorial.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CURRENCY")
@Getter
@Setter
@ToString
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CCY_CODE")
    private String ccyCode;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "FX_RATE")
    private float fxRate;

    public Currency() {
    }

    public Currency(String ccyCode, String currency, float fxRate) {
        this.ccyCode = ccyCode;
        this.currency = currency;
        this.fxRate = fxRate;
    }
}
