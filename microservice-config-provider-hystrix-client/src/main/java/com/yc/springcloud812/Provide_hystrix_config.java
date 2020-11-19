package com.yc.springcloud812;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.sql.DataSource;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient   //启用服务发现客户端,以获取当前provider的注册信息
@EnableCircuitBreaker
public class Provide_hystrix_config {

	public static void main(String[] args) {

		SpringApplication.run(Provide_hystrix_config.class, args);
	}

}
