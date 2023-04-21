package com.innowise.currencies.dto;

import com.innowise.currencies.model.CurrencyName;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class CurrencyRateResponse {
    private CurrencyName base = CurrencyName.EUR;
    private Map<CurrencyName, Float> rates;
    private LocalDate date;
}
