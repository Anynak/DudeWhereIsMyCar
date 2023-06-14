package com.innowise.currencies.controllers;

import com.innowise.currencies.dto.CurrencyRateResponse;
import com.innowise.currencies.model.CurrencyName;
import com.innowise.currencies.services.CurrencyRateHandler;
import com.innowise.currencies.services.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/currency/v1")
public class CurrencyController {

    private final CurrencyRateHandler currencyRateHandler;
    private final CurrencyRateService currencyRateService;

    @GetMapping
    public CurrencyRateResponse getCurrencyRate(@RequestParam("base") CurrencyName base, @RequestParam("rates") List<CurrencyName> rateRequests) {
        CurrencyRateResponse rawCurrencyRateResponse = currencyRateService.getLast();
        return currencyRateHandler.handleResponse(base, rateRequests, rawCurrencyRateResponse);
    }

}
