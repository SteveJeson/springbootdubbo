package com.zdzc.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboServerApplication.class, args);
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
