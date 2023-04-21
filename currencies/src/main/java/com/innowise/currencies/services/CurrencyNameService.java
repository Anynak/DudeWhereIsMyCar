package com.innowise.currencies.services;

import com.innowise.currencies.model.Currency;
import com.innowise.currencies.model.CurrencyName;

import java.util.List;

public interface CurrencyNameService {
    Currency getByName(String name);

    Currency getByName(CurrencyName name);

    List<Currency> saveAll(List<CurrencyName> currencies);


}
