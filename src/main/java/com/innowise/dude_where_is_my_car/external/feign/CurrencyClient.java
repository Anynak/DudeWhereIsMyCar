package com.innowise.dude_where_is_my_car.external.feign;

import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyName;
import com.innowise.dude_where_is_my_car.external.feign.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "currency", url = "${openfeign.client.currencies.getClient.url}")
//@FeignClient(value = "currency", url = "openfeign.client.currencies.getClient.url")
public interface CurrencyClient {

    @GetMapping(value = {"/v1"}, produces = "application/json")
    //@RequestMapping(value = "/v1", produces = "application/json", method = RequestMethod.GET)
    CurrencyRateResponse getCurrencyRate(@RequestParam("base") CurrencyName base, @RequestParam("rates") List<CurrencyName> rateRequests);

}
