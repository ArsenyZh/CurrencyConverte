package com.example.CurrencyConverter.mapper;

import com.example.CurrencyConverter.dto.CurrencyDto;
import com.example.CurrencyConverter.entity.Currency;
import com.example.CurrencyConverter.repository.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CurrencyMapper {
    private CurrencyRepository currencyRepository;

    public Currency toCurrency(CurrencyDto currencyDto) {
        return currencyRepository.findByCode(currencyDto.getCode());
    }

    public List<Currency> toCurrencyList(List<CurrencyDto> currencyDtoList) {
        List<Currency> currencyList = new ArrayList<>();

        for (CurrencyDto dto : currencyDtoList) {
            currencyList.add(currencyRepository.findByCode(dto.getCode()));
        }
        return currencyList;
    }

    public CurrencyDto toDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setCode(currency.getCode());
        currencyDto.setFullName(currency.getFullName());
        currencyDto.setSign(currency.getSign());

        return currencyDto;
    }

    public List<CurrencyDto> toCurrencyDtoList(List<Currency> currencyList) {
        List<CurrencyDto> currencyDtoList = new ArrayList<>();
        CurrencyDto currencyDto = new CurrencyDto();

        for (Currency currency : currencyList) {
            currencyDto.setCode(currency.getCode());
            currencyDto.setFullName(currency.getFullName());
            currencyDto.setSign(currency.getSign());

            currencyDtoList.add(currencyDto);
        }
        return currencyDtoList;
    }
}
