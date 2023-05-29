package com.innowise.currencies.dto.mappers;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.Currency;
import com.innowise.currencies.model.CurrencyName;
import com.innowise.currencies.model.CurrencyRate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CurrencyRateMapper {
    default List<CurrencyRate> toCurrencyRates(CurrencyRateResponse rateResponse, List<Currency> currencies) {

        return currencies.stream().map(currency -> {
            CurrencyRate rate = new CurrencyRate();
            rate.setCurrency(currency);
            rate.setRate(rateResponse.getRates().get(CurrencyName.valueOf(currency.getCurrencyName())));
            rate.setDate(rateResponse.getDate());
            return rate;
        }).toList();

    }

    default CurrencyRateResponse toCurrencyRateResponse(List<CurrencyRate> rateList) {

        Map<CurrencyName, Float> rates = new EnumMap<>(CurrencyName.class);
        for (CurrencyRate cr : rateList) {
            rates.put(CurrencyName.valueOf(cr.getCurrency().getCurrencyName()), cr.getRate());
        }
        CurrencyRateResponse response = new CurrencyRateResponse();
        response.setRates(rates);
        response.setDate(rateList.get(0).getDate());
        return response;

    }

}
