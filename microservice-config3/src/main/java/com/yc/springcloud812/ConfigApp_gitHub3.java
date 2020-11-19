package com.yc.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigApp_gitHub3 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp_gitHub3.class, args);
    }
}
