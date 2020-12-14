package com.xixiaoshi.hello.spring.cloud.web.admin.feign.service.hystrix;

import com.xixiaoshi.hello.spring.cloud.web.admin.feign.service.IAdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystrix implements IAdminService {
    @Override
    public String hello(String message) {
        return String.format("your message is %s, but server(feign) occurs error", message);
    }
}
