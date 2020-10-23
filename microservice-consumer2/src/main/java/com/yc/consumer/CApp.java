package com.yc.consumer;

import com.yc.consumer.robinConfiguration.RobinConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient   //启用eureka客户端，这样能完成服务发现

//指定新的的负载算法给MICROSERVICE-PROVIDER服务用
//这里的name指服务的名称，如果需要多个服务提供方，这个时候可以使用@RibbonClents进行配置
@RibbonClient(name = "MICROSERVICE-PROVIDER",configuration = RobinConfiguration.class)
//多个不同的策略使用@RibbonClents(value="")
public class CApp {

	public static void main(String[] args) {

		SpringApplication.run(CApp.class, args);
	}
}