package com.example.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;
import org.beetl.sql.annotation.entity.AutoID;
import org.beetl.sql.annotation.entity.Table;

import java.util.Date;

@Data
@Accessors(chain = true)
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