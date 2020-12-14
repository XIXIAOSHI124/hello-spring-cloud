package com.xixiaoshi.hello.spring.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.CharSet;
import org.apache.http.protocol.RequestContent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class LoginFilter extends ZuulFilter {

    private Logger logger = Logger.getLogger(LoginFilter.class.getName());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String token = request.getParameter("token");
        if(null == token) {
            logger.warning("Token is empty");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            try {
                HttpServletResponse response = context.getResponse();
                response.setContentType(String.format("%s;%s", MediaType.TEXT_HTML_VALUE, "charset=utf-8"));
                response.getWriter().write("Token is invalid");
            } catch (IOException e) {

            }
        } else {
            logger.info("Login successfully.");
        }
        return null;
    }
}
