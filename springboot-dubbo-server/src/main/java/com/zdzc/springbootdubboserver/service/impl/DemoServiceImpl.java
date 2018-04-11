package com.zdzc.springbootdubboserver.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.springbootdubboapi.service.DemoService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
