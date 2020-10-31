package com.yc.springcloud812.fallBack;

import com.yc.springcloud812.bean.Book;
import com.yc.springcloud812.service.IProductClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


//此类表示当   正常服务访问不到时，熔断的处理类
@Component
public class IBookClientServiceFallBackFactory implements FallbackFactory<IProductClientService> {

    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Book getBook(long id) {
                Book p = new Book();
                p.setBookId(  (int) id);
                p.setBookName("服务器忙！！");
                return p;
            }

            @Override
            public List<Book> listBook() {
                return null;
            }
        };
    }
}
