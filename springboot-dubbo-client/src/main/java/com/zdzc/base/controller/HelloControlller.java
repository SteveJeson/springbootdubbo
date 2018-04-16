package com.zdzc.base.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdzc.base.service.DemoService;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloControlller {

    @Reference(version="1.0.0")
    private DemoService demoService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(@RequestParam(value = "name") String name) {
        return demoService.sayHello(name);
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Welcome to springboot dubbo!";
    }

}
