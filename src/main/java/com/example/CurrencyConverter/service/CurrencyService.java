package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.dto.CurrencyDto;
import com.example.CurrencyConverter.entity.Currency;
import com.example.CurrencyConverter.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> findAllCurrency() {
        return currencyRepository.findAll();
    }

    public Currency findById(Long id) {
        return currencyRepository.findById(id).orElse(null);
    }

    public Currency findByCode(String code) {
        return currencyRepository.findByCode(code);
    }

    public Currency addCurrency(Currency currency) {
        Currency newCurrency = currencyRepository.save(currency);

        return newCurrency;
    }

    public void deleteCurrency(Long id) {
        Currency currency = currencyRepository.findById(id).orElse(null);

        if (currency != null) {
            currencyRepository.delete(currency);
        }
    }

    public void deleteCurrency(Currency currency) {
        currencyRepository.delete(currency);
    }
}
