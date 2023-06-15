package com.innowise.currencies.services;

import com.innowise.currencies.model.Currency;
import com.innowise.currencies.model.CurrencyName;
import com.innowise.currencies.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyNameService {
    private final CurrencyRepository currencyRepository;


    public Currency getByName(String currencyName) {
        return currencyRepository.findByCurrencyName(currencyName).orElseThrow();
    }


    public Currency getByName(CurrencyName currencyName) {
        return currencyRepository.findByCurrencyName(currencyName.name()).orElseThrow();
    }


    public List<Currency> saveAll(List<CurrencyName> currencies) {
        List<Currency> c = currencies.stream().map(s -> new Currency(s.name())).toList();
        return currencyRepository.saveAll(c);
    }
}
