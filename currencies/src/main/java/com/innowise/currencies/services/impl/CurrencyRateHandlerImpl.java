package com.innowise.currencies.services.impl;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.CurrencyName;
import com.innowise.currencies.services.CurrencyRateHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyRateHandlerImpl implements CurrencyRateHandler {


    @Override
    public CurrencyRateResponse handleResponse(CurrencyName base, List<CurrencyName> rateRequests, CurrencyRateResponse rawResponse) {
        CurrencyRateResponse handledResponse = new CurrencyRateResponse();
        handledResponse.setBase(base);
        handledResponse.setRates(
                this.removeUnneededRates(rawResponse.getRates(),
                        rateRequests));

        handledResponse.setRates(
                this.convertToBaseCurrency(handledResponse.getRates(),
                        rawResponse.getRates().get(base)));

        return handledResponse;
    }

    /**
     * it removes exchange rates that the user did not request
     */
    private Map<CurrencyName, Float> removeUnneededRates(Map<CurrencyName, Float> rates, List<CurrencyName> rateRequests) {
        return rates.entrySet().stream()
                .filter(entry -> rateRequests.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * since rawResponse contains a list of rates relative to EUR as base currency,
     * it is necessary to recalculate the rates
     * according to the new base currency provided by the user
     */
    private Map<CurrencyName, Float> convertToBaseCurrency(Map<CurrencyName, Float> rates, Float base) {
        return rates.entrySet().stream()
                .peek(entry -> {
                    Float newRate = entry.getValue() / base;
                    DecimalFormat df = new DecimalFormat("#.######");
                    newRate = Float.parseFloat(df.format(newRate));
                    entry.setValue(newRate);
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
