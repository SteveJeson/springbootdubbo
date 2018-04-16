package com.zdzc.base.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdzc.base.service.DemoService;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
