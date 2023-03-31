package com.innowise.DudeWhereIsMyCar.external.feign.dto;

import lombok.Data;

import java.util.List;


@Data
public class CurrencyRateRequest {
    private CurrencyName baseCurrency;
    private List<CurrencyName> rateRequests;
}
