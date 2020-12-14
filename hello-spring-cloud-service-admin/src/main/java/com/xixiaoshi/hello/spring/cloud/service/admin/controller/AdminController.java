package com.xixiaoshi.hello.spring.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;

    @Value("${server.hostname}")
    private String hostname;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(String message) {
        return String.format("%s:%s - Hello your message is: %s",hostname, port, message);
    }
}
