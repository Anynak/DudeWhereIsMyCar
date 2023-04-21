package com.innowise.currencies.services;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.CurrencyName;

import java.util.List;

public interface CurrencyRateHandler {
    CurrencyRateResponse handleResponse(CurrencyName base, List<CurrencyName> rateRequests, CurrencyRateResponse rawResponse);
}
