package com.example.CurrencyConverter.dto;

import com.example.CurrencyConverter.entity.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {
    private Currency baseCurrency;
    private Currency targetCurrency;
    private double rate;
}
