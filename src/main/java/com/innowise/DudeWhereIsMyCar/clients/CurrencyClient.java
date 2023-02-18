package com.innowise.DudeWhereIsMyCar.clients;

import com.innowise.DudeWhereIsMyCar.clients.DTO.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "currency", url = "https://api.exchangerate.host")
public interface CurrencyClient {

    @RequestMapping(value = {"/convert?from={from}&to={to}"}, method = RequestMethod.GET)
    Info getCurrencyRate(@PathVariable String from, @PathVariable String to);

}
