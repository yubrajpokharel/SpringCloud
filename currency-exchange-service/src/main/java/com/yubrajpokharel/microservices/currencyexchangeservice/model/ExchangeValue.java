package com.yubrajpokharel.microservices.currencyexchangeservice.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * Created by yubrajpokharel on 1/4/18.
 */

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExchangeValue {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
