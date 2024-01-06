package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.entity.Currency;
import com.example.CurrencyConverter.entity.ExchangeRate;
import com.example.CurrencyConverter.repository.CurrencyRepository;
import com.example.CurrencyConverter.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository exchangeRateRepository;
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<ExchangeRate> findAllExchangeRate() {
        return exchangeRateRepository.findAll();
    }

    public ExchangeRate findById(Long id) {
        return exchangeRateRepository.findById(id).orElse(null);
    }

    public ExchangeRate findByCodes(String baseCode, String targetCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCode);
        Currency targetCurrency = currencyRepository.findByCode(targetCode);

        return exchangeRateRepository.findByBaseCurrencyAndTargetCurrency(baseCurrency, targetCurrency);
    }

    public ExchangeRate addExchangeRate(ExchangeRate exchangeRate) {
        ExchangeRate newExchangeRate = exchangeRateRepository.save(exchangeRate);

        return newExchangeRate;
    }

    public ExchangeRate updateExchangeRate(ExchangeRate exchangeRate, double rate) {
        exchangeRate.setRate(rate);
        exchangeRateRepository.save(exchangeRate);

        return exchangeRate;
    }

    public double exchangeCurrency() {
        return 0;
    }
}
