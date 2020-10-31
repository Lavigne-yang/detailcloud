package com.yc.springcloud812.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class PUser implements Serializable {

    private Integer age;
    private String name;
    private String sex;
}
