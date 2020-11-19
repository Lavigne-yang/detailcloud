package com.yc.springcloud812.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @RequestMapping("/config")
    public String getConfig() {
        //microservice-client-c====
        return "ApplicationName = " + this.applicationName + "、EurekaServers = "
                + this.eurekaServers;
    }
}