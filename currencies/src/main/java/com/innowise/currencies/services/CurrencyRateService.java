package com.innowise.currencies.services;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.dto.mappers.CurrencyRateMapper;
import com.innowise.currencies.exceptions.ResourceNotFoundException;
import com.innowise.currencies.external.feign.CurrencyClient;
import com.innowise.currencies.model.Currency;
import com.innowise.currencies.model.CurrencyRate;
import com.innowise.currencies.repositories.CurrencyRateRepository;
import com.innowise.currencies.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {
    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyClient currencyClient;
    private final CurrencyRateMapper currencyRateMapper;
    private final CurrencyRepository currencyRepository;


    public CurrencyRate add(CurrencyRate currencyRate) {
        return currencyRateRepository.save(currencyRate);
    }


    private void addAll(List<CurrencyRate> currencyRates) {
        currencyRateRepository.saveAll(currencyRates);
    }

    /**
     * When it tries to get the last exchange rates,
     * first the information is searched in the database.
     * if it is not there, the exchange rates are pulled from the external API
     * and saved in the database
     */

    public CurrencyRateResponse getLast() {
        LocalDate lastDate = currencyRateRepository.findLatestDate();
        List<CurrencyRate> currencyRates = getByDateWithCurrency(lastDate);
        if (!currencyRates.isEmpty()) {
            return currencyRateMapper.toCurrencyRateResponse(currencyRates);
        } else {
            CurrencyRateResponse response = currencyClient.getCurrencyRate();
            this.updateCurrencies(response);
            return response;
        }

    }

    private void updateCurrencies(CurrencyRateResponse response) {
        List<Currency> currencies = currencyRepository.findAll();
        List<CurrencyRate> currencyRates = currencyRateMapper.toCurrencyRates(response, currencies);
        this.addAll(currencyRates);
    }


    public List<CurrencyRate> getByDateWithCurrency(LocalDate date) {
        return currencyRateRepository.findAllByDateWithCurrency(date).orElseThrow(() -> new ResourceNotFoundException("no CurrencyRate with date: " + date));
    }

}
