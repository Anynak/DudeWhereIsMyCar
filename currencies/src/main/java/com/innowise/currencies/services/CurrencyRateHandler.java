package com.innowise.currencies.services;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.CurrencyName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyRateHandler {


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
        // Use a lambda expression to simplify the stream operation
        return rates.entrySet().stream()
                .map(entryRate -> {
                    // Use BigDecimal to avoid floating-point errors
                    BigDecimal newRate = BigDecimal.valueOf(entryRate.getValue())
                            .divide(BigDecimal.valueOf(base), 6, RoundingMode.HALF_UP);
                    // Use the CurrencyName enum as the key instead of the entryRate object
                    return new AbstractMap.SimpleEntry<>(entryRate.getKey(), newRate.floatValue());
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
