package com.yc.springcloud812.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardApp {
    public static void main(String[] args) {
        SpringApplication.run(
                HystrixDashBoardApp.class,args
        );
    }
}
