package com.example.CurrencyConverter.service;

import com.example.CurrencyConverter.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CurrencyService {
    private CurrencyRepository currencyRepository;
}
