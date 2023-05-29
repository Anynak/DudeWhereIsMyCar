package com.innowise.dude_where_is_my_car.external.feign.dto;

import lombok.Data;

import java.util.List;


@Data
public class CurrencyRateRequest {
    private CurrencyName baseCurrency;
    private List<CurrencyName> rateRequests;
}
