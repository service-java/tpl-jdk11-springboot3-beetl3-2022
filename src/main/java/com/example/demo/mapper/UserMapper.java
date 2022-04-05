package com.example.demo.mapper;

import cn.hutool.core.util.StrUtil;
import com.example.demo.entity.User;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Template;
import org.beetl.sql.mapper.annotation.Update;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    String userCol = "name, age, create_time";

    @Template("""
-- sql语法高亮开启
select * 
from user 
where age = #{age}
order by id    
            """)
    List<User> listByAge(Integer age);


    @Template("""
select """+userCol+"""
from sys_user u
where 1=1
-- @if(!isBlank(userName)){
    and user_name = #{userName}
-- @}          
order by u.dept_id desc
            """)
    List<User> listByUserName(String name);


    @Template("""
insert into user(`name`, age, create_time)
values
-- @trim(){for(item in list) {
(#{item.name}, #{item.age}, #{item.createTime}),
-- @}}
            """)
    @Update
    Integer saveBatchUser(List<User> list);
}