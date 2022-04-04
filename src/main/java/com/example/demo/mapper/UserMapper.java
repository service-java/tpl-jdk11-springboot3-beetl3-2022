package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.BatchUpdate;
import org.beetl.sql.mapper.annotation.Template;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Template("""
select * 
from user 
where age = #{age}
order by id    
            """)
    List<User> listByAge(Integer age);

    @Template("""
-- 一行注释
select *
from sys_user u
where 1=1
-- @if(!isBlank(userName)){
    and user_name = #{userName}
-- @}          
order by u.dept_id desc
            """)
    List<User> listByUserName(String name);

    @Template("""
insert into demo_dept(name, date_create)
values
-- @trim(){for(item in list) {
(#{item.name}, #{item.dateCreate}),
-- @}}
            """)
    @BatchUpdate
    Integer saveBatchUser(List<User> list);
}