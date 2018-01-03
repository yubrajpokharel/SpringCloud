package com.yubrajpokharel.microservices.limitservice.configuration;

import lombok.*;

/**
 * Created by yubrajpokharel on 1/3/18.
 */

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LimitConfiguration {

    private int maximum;
    private int minimum;

}
