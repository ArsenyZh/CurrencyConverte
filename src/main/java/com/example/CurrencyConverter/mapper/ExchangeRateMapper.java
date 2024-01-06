package com.example.CurrencyConverter.mapper;

import com.example.CurrencyConverter.dto.ExchangeRateDto;
import com.example.CurrencyConverter.entity.ExchangeRate;
import com.example.CurrencyConverter.repository.CurrencyRepository;
import com.example.CurrencyConverter.repository.ExchangeRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ExchangeRateMapper {
    private ExchangeRateRepository exchangeRateRepository;
    private CurrencyRepository currencyRepository;

    public ExchangeRate toExchangeRate(ExchangeRateDto exchangeRateDto) {
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setBaseCurrency(exchangeRateDto.getBaseCurrency());
        exchangeRate.setTargetCurrency(exchangeRateDto.getTargetCurrency());
        exchangeRate.setRate(exchangeRateDto.getRate());

        return exchangeRate;
    }

    public List<ExchangeRate> toExchangeRateList(List<ExchangeRateDto> exchangeRateDtoList) {
        List<ExchangeRate> exchangeRateList = new ArrayList<>();
        ExchangeRate exchangeRate = new ExchangeRate();

        for (ExchangeRateDto dto : exchangeRateDtoList) {
            exchangeRate.setBaseCurrency(dto.getBaseCurrency());
            exchangeRate.setTargetCurrency(dto.getTargetCurrency());
            exchangeRate.setRate(dto.getRate());
        }
        return exchangeRateList;
    }

    public ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();

        exchangeRateDto.setBaseCurrency(exchangeRate.getBaseCurrency());
        exchangeRateDto.setTargetCurrency(exchangeRate.getTargetCurrency());
        exchangeRateDto.setRate(exchangeRate.getRate());

        return exchangeRateDto;
    }

    public List<ExchangeRateDto> exchangeRateDtoList(List<ExchangeRate> exchangeRateList) {
        List<ExchangeRateDto> exchangeRateDtoList = new ArrayList<>();
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();

        for (ExchangeRate exchangeRate : exchangeRateList) {
            exchangeRateDto.setBaseCurrency(exchangeRate.getBaseCurrency());
            exchangeRateDto.setTargetCurrency(exchangeRate.getTargetCurrency());
            exchangeRateDto.setRate(exchangeRate.getRate());

            exchangeRateDtoList.add(exchangeRateDto);
        }
        return exchangeRateDtoList;
    }

}
