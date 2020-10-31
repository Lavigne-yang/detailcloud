package com.yc.springcloud812.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yc.springcloud812.bean.PUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class PUsercontroller {

    @RequestMapping("/get/{name}")
    @HystrixCommand
    public  Object get(@PathVariable("name")String name) {
        PUser users = new PUser();
        users.setName(name);
        users.setAge(18);
        users.setSex("F");
        return users;
    }
}
