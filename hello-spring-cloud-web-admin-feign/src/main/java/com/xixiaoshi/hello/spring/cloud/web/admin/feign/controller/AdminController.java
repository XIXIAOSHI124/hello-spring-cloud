package com.xixiaoshi.hello.spring.cloud.web.admin.feign.controller;

import com.xixiaoshi.hello.spring.cloud.web.admin.feign.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(String message) {
        return adminService.hello(message);
    }
}
