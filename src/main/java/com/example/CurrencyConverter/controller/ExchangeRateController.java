package com.example.CurrencyConverter.controller;

import com.example.CurrencyConverter.dto.ExchangeRateDto;
import com.example.CurrencyConverter.dto.ExchangeResponseDto;
import com.example.CurrencyConverter.entity.ExchangeRate;
import com.example.CurrencyConverter.mapper.ExchangeRateMapper;
import com.example.CurrencyConverter.service.CurrencyService;
import com.example.CurrencyConverter.service.ExchangeRateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService exchangeRateService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private ExchangeRateMapper exchangeRateMapper;

    @GetMapping("/exchangeRates")
    public List<ExchangeRateDto> getAllExchangeRate() {
        System.out.println(exchangeRateMapper.exchangeRateDtoList(exchangeRateService.findAllExchangeRate()));
        return exchangeRateMapper.exchangeRateDtoList(exchangeRateService.findAllExchangeRate());
    }

    @GetMapping("/exchangeRate/{doubleCode}")
    public ExchangeRateDto getExchangeRateByCodes(@PathVariable("doubleCode") String doubleCode) {
        String baseCode = doubleCode.substring(0, 3);
        String targetCode = doubleCode.substring(3, 6);
        ExchangeRateDto exchangeRateDto = exchangeRateMapper.toExchangeRateDto(exchangeRateService.findByCodes(baseCode, targetCode));

        return exchangeRateDto;
    }

    @GetMapping("/exchange")
    public ExchangeResponseDto getConvertedAmount(@RequestParam("from") String baseCode,
                                                  @RequestParam("to") String targetCode,
                                                  @RequestParam("amount") double amount) {
        ExchangeRate exchangeRate = exchangeRateService.findByCodes(baseCode, targetCode);
        double convertedAmount = exchangeRate.getRate() * amount;

        ExchangeResponseDto exchangeResponseDto = new ExchangeResponseDto();
        exchangeResponseDto.setBaseCurrency(currencyService.findByCode(baseCode));
        exchangeResponseDto.setTargetCurrency(currencyService.findByCode(targetCode));
        exchangeResponseDto.setConvertedAmount(convertedAmount);

        return exchangeResponseDto;
    }

    @PostMapping("/exchangeRates")
    public ExchangeRateDto addExchangeRate(@RequestParam("baseCode") String baseCode, @RequestParam("targetCode") String targetCode,
                                           @RequestParam("rate") double rate) {
        ExchangeRate tempExchangeRate = new ExchangeRate();
        tempExchangeRate.setBaseCurrency(currencyService.findByCode(baseCode));
        tempExchangeRate.setTargetCurrency(currencyService.findByCode(targetCode));
        tempExchangeRate.setRate(rate);

        ExchangeRate exchangeRate = exchangeRateService.addExchangeRate(tempExchangeRate);

        return  exchangeRateMapper.toExchangeRateDto(exchangeRate);
    }

    @PutMapping("/exchangeRate/{doubleCode}")
    public ExchangeRateDto updateExchangeRate(@PathVariable("doubleCode") String doubleCode, @RequestParam double rate) {
        String baseCode = doubleCode.substring(0, 3);
        String targetCode = doubleCode.substring(3, 6);
        ExchangeRate exchangeRate = exchangeRateService.findByCodes(baseCode, targetCode);

        if (exchangeRate == null) {
            return null;
        }

        ExchangeRateDto exchangeRateDto = exchangeRateMapper.toExchangeRateDto(exchangeRateService.updateExchangeRate(exchangeRate, rate));

        return  exchangeRateDto;
    }
}
