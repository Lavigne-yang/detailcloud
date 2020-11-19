package com.yc.springcloud812.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yc.springcloud812.bean.Book;
import com.yc.springcloud812.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    @HystrixCommand(fallbackMethod = "errorCallBack")
    public Object getBook(@PathVariable("id") Integer id){

        show();
        Book p=this.bookService.getBook(id);
        if( p==null){
            throw new RuntimeException("查无此产品");
        }
        return p;
    }

    //指定一个降级的方法
    public Object errorCallBack(  @PathVariable("id") Integer id   ){
//        Book b=new Book();
//        b.setBookId(id);
//        b.setBookName("不存在,error,请稍后重试！！！");
        return id+"&nbsp查无此书";
    }

    @GetMapping("findAll")
    public List<Book> findAll(){
        show();
       return bookService.findAll();
    }

    private void show(){
        System.out.println( this.discoveryClient.description() );

        //EurekaDiscoveryClient
        EurekaDiscoveryClient edc=(EurekaDiscoveryClient)this.discoveryClient;
        // 服务器上有有很多服务
        List<String> servicesName=edc.getServices();
        for( String sn:servicesName ){
            System.out.println("服务名:"+ sn );
            List<ServiceInstance> instances=edc.getInstances(  sn );
            for(  ServiceInstance si:instances ){
                System.out.println(  si.getScheme()+" "+  si.getHost() +" "+si.getPort()+" "+ si.getUri()  );
            }
        }
    }

}
