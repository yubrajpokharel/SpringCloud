package com.yubrajpokharel.microservices.currencyconversionservice.proxy;

import com.yubrajpokharel.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by yubrajpokharel on 1/5/18.
 */

//@FeignClient(name = "currency-exchange-server", url = "localhost:8000")
@FeignClient(name = "currency-exchange-server")
@RibbonClient(name = "currency-exchange-server")
public interface CurrenctyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retriveValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
