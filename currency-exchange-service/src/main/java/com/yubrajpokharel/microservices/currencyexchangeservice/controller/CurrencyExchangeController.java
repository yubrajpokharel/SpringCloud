package com.yubrajpokharel.microservices.currencyexchangeservice.controller;

import com.yubrajpokharel.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by yubrajpokharel on 1/4/18.
 */

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retriveValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = new ExchangeValue(1000L, "USD", "NPR", BigDecimal.valueOf(102));
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

}
