package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ExchangeRateService {
    private ExchangeRateRepository exchangeRateRepository;
}
