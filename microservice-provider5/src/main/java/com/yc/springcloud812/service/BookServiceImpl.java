package com.yc.springcloud812.service;

import com.yc.springcloud812.bean.Book;
import com.yc.springcloud812.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements com.yc.springcloud812.service.BookService {

    @Autowired(required = false)
    private BookMapper bookMapper;


    @Override
    public Book getBook(Integer id) {

        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> findAll() {

        return bookMapper.selectAll();
    }
}
