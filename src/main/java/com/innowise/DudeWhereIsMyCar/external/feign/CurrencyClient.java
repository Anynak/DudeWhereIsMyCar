package com.innowise.DudeWhereIsMyCar.external.feign;

import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyRateRequest;
import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "currency", url = "currencies:8082/api/currency")
public interface CurrencyClient {

    @GetMapping(value = {"/v1"}, produces = "application/json")
        //@RequestMapping(value = "/convert", method = RequestMethod.GET)
    CurrencyRateResponse getCurrencyRate(@RequestBody CurrencyRateRequest rateRequest);

}
