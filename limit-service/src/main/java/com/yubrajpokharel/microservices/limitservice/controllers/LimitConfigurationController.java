package com.yubrajpokharel.microservices.limitservice.controllers;

import com.yubrajpokharel.microservices.limitservice.configuration.Configuration;
import com.yubrajpokharel.microservices.limitservice.configuration.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yubrajpokharel on 1/3/18.
 */

@RestController
public class LimitConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retriveLimitsFromConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
