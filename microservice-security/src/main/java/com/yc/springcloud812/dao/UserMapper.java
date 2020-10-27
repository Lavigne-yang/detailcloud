package com.yc.springcloud812.dao;

import com.yc.springcloud812.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    public User queryUserByUserName(String username);
}