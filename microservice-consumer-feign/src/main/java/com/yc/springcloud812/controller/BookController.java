package com.yc.springcloud812.controller;


import com.yc.springcloud812.service.IProductClientService;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class BookController {

    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private LoadBalancerClient loadBalancerClient; //服务提供方法信息

    @GetMapping("/{id}")
    public Object get(@PathVariable("id") Integer id) {
        return this.iProductClientService.getBook(id);
    }

    @GetMapping("/findAll")
    public Object list() {
        return this.iProductClientService.listBook();
    }

//    @RequestMapping("/product/add")
//    public Object add(Book product) {
//        return this.iProductClientService.addPorduct(product);
//    }
}