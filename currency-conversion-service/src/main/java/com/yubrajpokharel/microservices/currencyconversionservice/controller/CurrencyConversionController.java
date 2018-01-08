package com.yubrajpokharel.microservices.currencyconversionservice.controller;

import com.yubrajpokharel.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.yubrajpokharel.microservices.currencyconversionservice.proxy.CurrenctyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yubrajpokharel on 1/4/18.
 */

@RestController
public class CurrencyConversionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrenctyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){

        CurrencyConversionBean response = proxy.retriveValue(from, to);
        logger.info("--------------------------------------------------------------------");
        logger.info("Conversion Server -> {}", response);
        logger.info("--------------------------------------------------------------------");
        return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity){
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("from", from);
        urlVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> beanResponseEntity = new RestTemplate().getForEntity(
                                                                    "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                                                                        CurrencyConversionBean.class,
                                                                        urlVariables);

        CurrencyConversionBean response = beanResponseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), response.getFrom(), response.getTo(), response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}