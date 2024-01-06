package com.example.CurrencyConverter.controller;

import com.example.CurrencyConverter.dto.CurrencyDto;
import com.example.CurrencyConverter.mapper.CurrencyMapper;
import com.example.CurrencyConverter.service.CurrencyService;
import com.example.CurrencyConverter.entity.Currency;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private CurrencyMapper currencyMapper;

    @GetMapping("/currencies")
    public List<CurrencyDto> getAllCurrencies() {
        List<CurrencyDto> currencyDtoList = currencyMapper.toCurrencyDtoList(currencyService.findAllCurrency());

        return currencyDtoList;
    }

    @GetMapping("/currency/id/{id}")
    public CurrencyDto getCurrencyById(@PathVariable("id") Long id) {
        CurrencyDto currencyDto = currencyMapper.toDto(currencyService.findById(id));

        return currencyDto;
    }

    @GetMapping("/currency/{code}")
    public CurrencyDto getCurrencyById(@PathVariable("code") String code) {
        CurrencyDto currencyDto = currencyMapper.toDto(currencyService.findByCode(code));

        return currencyDto;
    }

    @PostMapping("/currency")
    public CurrencyDto addCurrency(@RequestBody CurrencyDto currencyDto) {
        Currency currency = currencyMapper.toCurrency(currencyDto);
        System.out.println(currency);
        currencyService.addCurrency(currency);

        return currencyDto;
    }

    @DeleteMapping("/currency/{code}")
    public void deleteCurrency(@PathVariable("code") String code) {
        currencyService.deleteCurrency(currencyService.findByCode(code));
    }

    @DeleteMapping("/currency/id/{id}")
    public void deleteCurrency(@PathVariable("id") Long id) {
        currencyService.deleteCurrency(id);
    }
}
