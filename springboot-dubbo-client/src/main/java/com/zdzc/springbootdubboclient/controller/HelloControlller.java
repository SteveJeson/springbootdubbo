package com.zdzc.springbootdubboclient.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.springbootdubboapi.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControlller {

    @Reference(version="1.0.0")
    private DemoService demoService;

    @RequestMapping("/test")
    public String test() {
        return demoService.sayHello("dubbo");
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Welcome to springboot dubbo client!";
    }
}
