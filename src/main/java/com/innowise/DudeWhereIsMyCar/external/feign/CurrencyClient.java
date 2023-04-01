package com.innowise.DudeWhereIsMyCar.external.feign;

import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyName;
import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyRateRequest;
import com.innowise.DudeWhereIsMyCar.external.feign.dto.CurrencyRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "currency", url = "currencies:8080/api/currency")
public interface CurrencyClient {

    @GetMapping(value = {"/v1"}, produces = "application/json")
    //@RequestMapping(value = "/v1", produces = "application/json", method = RequestMethod.GET)
    CurrencyRateResponse getCurrencyRate(@RequestParam("base") CurrencyName base, @RequestParam("rates") List<CurrencyName> rateRequests);

}
