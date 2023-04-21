package com.innowise.currencies.external.feign;

import com.innowise.currencies.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "currency", url = "https://api.exchangerate.host")
public interface CurrencyClient {
    @GetMapping(value = {"/latest"}, produces = "application/json")
    CurrencyRateResponse getCurrencyRate();

}
