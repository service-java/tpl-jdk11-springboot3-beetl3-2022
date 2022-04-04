package com.example.demo.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Table(name="user")
public class User {
    @AutoID
    private Long id;

    private String name;
    private Integer age;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}