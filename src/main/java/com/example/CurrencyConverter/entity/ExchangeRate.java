package com.example.CurrencyConverter.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "exchangeRates")
@Data
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baseCurrencyId", referencedColumnName = "id")
    private Currency baseCurrency;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "targetCurrencyId", referencedColumnName = "id")
    private Currency targetCurrency;

    @Column(name = "rate")
    private double rate;
}
