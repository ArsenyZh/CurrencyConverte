package com.example.CurrencyConverter.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {
    private String code;
    private String fullName;
    private String sign;
}
