package com.yc.consumer.config;


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

    @Bean //创建一个 restTemplate 的模板操作对象
   // @LoadBalanced   //启用ribbon的客户端负载均衡
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }



//    @Bean
//    public HttpHeaders getHeaders(){
//        HttpHeaders headers=new HttpHeaders();
//        String auth="admin:a";   //认证的原始用户名和密码
//        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
//        String authHeader="Basic "+new String(encodeAuth);
//        headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
//        return headers;
//    }

    @Bean
    public HttpHeaders getHeaders(){
        HttpHeaders headers=new HttpHeaders();
        String auth="admin:a";   //认证的原始用户名和密码
        byte[] encodeAuth= Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //加密处理
        String authHeader="Basic "+new String(encodeAuth);
        headers.set("Authorization",authHeader);    //    Http请求头         Authorization: Base xxxxxxxxx
        return headers;
    }
}
