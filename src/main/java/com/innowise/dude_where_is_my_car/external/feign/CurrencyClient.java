package com.innowise.dude_where_is_my_car.external.feign;

import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyName;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${spring.feign.config.name}", url = "${spring.feign.config.url}")
public interface CurrencyClient {

    @GetMapping(value = {"${spring.feign.config.value.get_rate}"}, produces = "application/json")
    CurrencyRateResponse getCurrencyRate(@RequestParam("base") CurrencyName base, @RequestParam("rates") List<CurrencyName> rateRequests);

}
