package com.yc.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigBusClientBusApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigBusClientBusApp.class,args);
    }
}