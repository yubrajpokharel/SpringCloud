package com.yubrajpokharel.microservices.currencyexchangeservice.transaction;

import com.yubrajpokharel.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yubrajpokharel on 1/4/18.
 */
public interface ExchangeValueTransaction extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
