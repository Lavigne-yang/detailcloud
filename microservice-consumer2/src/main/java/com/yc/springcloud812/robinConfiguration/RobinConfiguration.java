package com.yc.springcloud812.robinConfiguration;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

//这个类暂时不会被spring托管
public class RobinConfiguration {

    @Bean
    public IRule ribbonRule(){  //IRule所有规则的标准
        return new com.netflix.loadbalancer.RandomRule();//随机的访问策略
    }
}
