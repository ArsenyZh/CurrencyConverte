package com.example.CurrencyConverter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateDto {
    private Long baseCurrencyId;
    private Long targetCurrencyId;
    private String baseCurrency;
    private String targetCurrency;
    private double rate;
}
