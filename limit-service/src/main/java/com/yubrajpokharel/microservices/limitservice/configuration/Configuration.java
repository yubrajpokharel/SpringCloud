package com.yubrajpokharel.microservices.limitservice.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by yubrajpokharel on 1/3/18.
 */

@Component
@ConfigurationProperties("limits-service")
public class Configuration {

    @Getter @Setter
    private int minimum;

    @Getter @Setter
    private int maximum;

}
