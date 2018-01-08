package com.yubrajpokharel.microservices.netflixzuulapigatewayserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yubrajpokharel on 1/6/18.
 */

@Component
public class ZuulLoggingFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("Request -> {}, Request URI -> {}", request, request.getRequestURI());

        return null;
    }
}
