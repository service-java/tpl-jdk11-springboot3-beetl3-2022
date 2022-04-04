package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.Sql;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Sql("""
        select * 
        from user 
        where age = #{age}
        order by id    
    """)
    List<User> listByAge(Integer age);

    @Sql("""
        -- 我是注释
        select *
        from sys_user u
        where 1=1
        -- @if(!isBlank(userName)){
            and user_name = #{userName}
        -- @}          
        order by u.dept_id desc
    """)
    List<User> listByUserName(String name);
}