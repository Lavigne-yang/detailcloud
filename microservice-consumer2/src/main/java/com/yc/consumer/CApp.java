package com.yc.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //启用eureka客户端，这样能完成服务发现
public class CApp {

	public static void main(String[] args) {

		SpringApplication.run(CApp.class ,args);
	}

}
