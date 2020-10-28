package com.yc.springcloud812;

import com.yc.springcloud812.robinConfiguration.RobinConfiguration;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient   //启用eureka客户端，这样能完成服务发现

//指定新的的负载算法给MICROSERVICE-PROVIDER服务用
//这里的name指服务的名称，如果需要多个服务提供方，这个时候可以使用@RibbonClents进行配置
@RibbonClient(name = "MICROSERVICE-PROVIDER",configuration = RobinConfiguration.class)
//多个不同的策略使用@RibbonClents(value="")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients("com.yc.springcloud812.service")  //注意:这里的值要填服务接口所在的包名,得到feigon接口通过动态代理生成代理对象
public class CAppfeign {

	public static void main(String[] args) {

		SpringApplication.run(CAppfeign.class, args);
	}
//	@Bean
//	Logger.Level feignLoggerLevel(){
//		return Logger.Level.FULL;
//	}

}