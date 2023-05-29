package com.innowise.dude_where_is_my_car.external.feign.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class CurrencyRateResponse {
    private CurrencyName base;
    private Map<CurrencyName, Float> rates;
    private LocalDate date;
}
