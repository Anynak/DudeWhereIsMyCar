package com.innowise.DudeWhereIsMyCar.controllers.clients;

import com.innowise.DudeWhereIsMyCar.controllers.clients.dto.CurrencyRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "currency", url = "https://api.exchangerate.host")
public interface CurrencyClient {

    //@GetMapping(value = {"/convert"}, produces = "application/json")
    @RequestMapping(value = "/convert", method = RequestMethod.GET)
    CurrencyRate getCurrencyRate(@RequestParam(value = "from") String from, @RequestParam(value = "to") String to);

}
