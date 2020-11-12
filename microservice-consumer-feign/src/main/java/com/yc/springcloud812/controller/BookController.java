package com.yc.springcloud812.controller;


import com.yc.springcloud812.service.IProductClientService;
import com.yc.springcloud812.service.IZUUlClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class BookController {

    @Resource
    private IProductClientService iProductClientService;

    @Resource
    private LoadBalancerClient loadBalancerClient; //服务提供方法信息

    @Resource
    private IZUUlClientService izuulClientService;

    private static Logger log= LoggerFactory.getLogger(BookController.class);

    @GetMapping("/{id}")
    public Object get(@PathVariable("id") Integer id) {
        return this.iProductClientService.getBook(id);
    }

    @GetMapping("/findAll")
    public Object list() {
        return this.iProductClientService.listBook();
    }

    @RequestMapping("/all/{id}")
    public Object getBookAndUser( @PathVariable("id") long id){
        log.info("*******"+id);
        Map<String,Object> result = new HashMap();
        result.put("book",izuulClientService.getBook(id));
        log.info("******" +result.get("book"));
        result.put("user",izuulClientService.getUser(id+""));
        result.put("user2",izuulClientService.getUser2(id+""));
        result.put("bookList",izuulClientService.findAllBook() );

        log.info("******" +result);
        return  result;
    }
}