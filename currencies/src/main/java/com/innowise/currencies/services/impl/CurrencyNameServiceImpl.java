package com.innowise.currencies.services.impl;

import com.innowise.currencies.model.Currency;
import com.innowise.currencies.model.CurrencyName;
import com.innowise.currencies.repositories.CurrencyRepository;
import com.innowise.currencies.services.CurrencyNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyNameServiceImpl implements CurrencyNameService {
    private final CurrencyRepository currencyRepository;

    @Override
    public Currency getByName(String currencyName) {
        return currencyRepository.findByCurrencyName(currencyName).orElseThrow();
    }

    @Override
    public Currency getByName(CurrencyName currencyName) {
        return currencyRepository.findByCurrencyName(currencyName.name()).orElseThrow();
    }


    @Override
    public List<Currency> saveAll(List<CurrencyName> currencies) {
        List<Currency> c = currencies.stream().map(s -> new Currency(s.name())).toList();
        return currencyRepository.saveAll(c);
    }
}
