package com.yc.springcloud812.fallBack;

import com.yc.springcloud812.bean.Book;
import com.yc.springcloud812.bean.PUser;
import com.yc.springcloud812.service.IZUUlClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IZuulClientServiceCallbackFactory implements FallbackFactory<IZUUlClientService> {
    @Override
    public IZUUlClientService create(Throwable throwable) {
        return new IZUUlClientService(){

            @Override
            public Book getBook(long id) {
                Book p=new Book();
                p.setBookId(1);
                p.setBookName("网络故障，请重试");
                //p.setBookDesc("");
                return p;
            }

            @Override
            public List<Book> findAllBook() {
                return null;
            }


            @Override
            public PUser getUser(String name) {
                PUser user = new PUser();
                user.setName("网络故障，请重试：");
                return user;
            }

            @Override
            public PUser getUser2(String name) {
                PUser user = new PUser();
                user.setName("网络故障，请重试！！！");
                return user;
            }
        };
    }
}
