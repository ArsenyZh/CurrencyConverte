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
        return exchangeRateRepository.findByBaseCurrencyAndTargetCurrency(currencyRepository.findById(exchangeRateDto.getBaseCurrencyId()).orElse(null),
                currencyRepository.findById(exchangeRateDto.getTargetCurrencyId()).orElse(null));
    }

    public List<ExchangeRate> toExchangeRateList(List<ExchangeRateDto> exchangeRateDtoList) {
        List<ExchangeRate> exchangeRateList = new ArrayList<>();

        for (ExchangeRateDto dto : exchangeRateDtoList) {
            exchangeRateRepository.findByBaseCurrencyAndTargetCurrency(currencyRepository.findById(dto.getBaseCurrencyId()).orElse(null),
                    currencyRepository.findById(dto.getTargetCurrencyId()).orElse(null));
        }
        return exchangeRateList;
    }

    public ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate) {
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();

        exchangeRateDto.setBaseCurrency(exchangeRate.getBaseCurrency().getCode());
        exchangeRateDto.setTargetCurrency(exchangeRate.getTargetCurrency().getCode());
        exchangeRateDto.setBaseCurrencyId(exchangeRate.getBaseCurrency().getId());
        exchangeRateDto.setTargetCurrencyId(exchangeRate.getTargetCurrency().getId());
        exchangeRateDto.setRate(exchangeRate.getRate());

        return exchangeRateDto;
    }

    public List<ExchangeRateDto> exchangeRateDtoList(List<ExchangeRate> exchangeRateList) {
        List<ExchangeRateDto> exchangeRateDtoList = new ArrayList<>();
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();

        for (ExchangeRate exchangeRate : exchangeRateList) {
            exchangeRateDto.setBaseCurrency(exchangeRate.getBaseCurrency().getCode());
            exchangeRateDto.setTargetCurrency(exchangeRate.getTargetCurrency().getCode());
            exchangeRateDto.setBaseCurrencyId(exchangeRate.getBaseCurrency().getId());
            exchangeRateDto.setTargetCurrencyId(exchangeRate.getTargetCurrency().getId());
            exchangeRateDto.setRate(exchangeRate.getRate());

            exchangeRateDtoList.add(exchangeRateDto);
        }
        return exchangeRateDtoList;
    }

}
