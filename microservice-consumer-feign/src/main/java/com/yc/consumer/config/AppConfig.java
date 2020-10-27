package com.yc.consumer.config;


import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

//一个配置类:由spring托管
//@SpringBootConfiguration
@Configuration
public class AppConfig {

    //-->Spring容器托管 “restTemplate”  RestTemplate对象
    @Bean //创建一个 restTemplate 的模板操作对象
    @LoadBalanced   //启用ribbon的客户端负载均衡   此处的负载均衡是全局配置( 针对当前的微服务)
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }


    //private static Logger logger= Logger.getLogger(AppConfig.class);

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        String auth="admin:a";//认证的原始用户名和密码
        //加密处理
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader="Basic "+new String(encodeAuth);
        //    Http请求头   Authorization: Base xxxxxxxxx
        headers.set("Authorization",authHeader);
        return headers;
    }

//    @Bean
//    public IRule ribbonRule(){  //IRule所有规则的标准
//        return new com.netflix.loadbalancer.RandomRule();//随机的访问策略
//    }

}
