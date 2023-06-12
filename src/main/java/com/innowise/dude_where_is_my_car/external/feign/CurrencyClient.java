package com.innowise.dude_where_is_my_car.external.feign;

import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyName;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "currency", url = "${cloud.openfeign.client.currency-service.url}")
public interface CurrencyClient {

    @GetMapping(value = {"/v1"}, produces = "application/json")
    CurrencyRateResponse getCurrencyRate(@RequestParam("base") CurrencyName base, @RequestParam("rates") List<CurrencyName> rateRequests);

}
