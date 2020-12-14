package com.xixiaoshi.hello.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "handleError")
    public String hello(String message) {
        String url = String.format("http://hello-spring-cloud-service-admin/hello?message=%s", message);
        return restTemplate.getForObject(url, String.class);
    }

    public String handleError(String message) {
        return String.format("your message is %s, but server(ribbon) occurs error", message);
    }
}
