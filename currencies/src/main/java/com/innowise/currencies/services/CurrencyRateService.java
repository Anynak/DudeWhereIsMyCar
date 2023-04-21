package com.innowise.currencies.services;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.CurrencyRate;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyRateService {
    CurrencyRate add(CurrencyRate currencyRate);

    CurrencyRateResponse getLast();

    List<CurrencyRate> getByDateWithCurrency(LocalDate date);

}
