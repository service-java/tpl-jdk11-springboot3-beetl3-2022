package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listByName")
    @ResponseBody
    public List<User> listByName(String name) {

        log.info("param: " + name);
        List<User> list = userMapper.createLambdaQuery()
                .andLike(User::getName, name + "%")
                .select();

        return list;
    }

    @GetMapping("/listByAge")
    @ResponseBody
    public List<User> listByAge(Integer age) {

        log.info("param: " + age);
        List<User> list = userMapper.listByAge(age, User._cols);

        return list;
    }

    @GetMapping("/saveBatchUser")
    @ResponseBody
    public String saveBatchUser() {
        var list = new ArrayList<User>();

        User user = null;

        for (int i = 0; i < 12; i++) {
            user = new User();
            user.setAge(11).setName("user_" + i).setCreateTime(new Date()).setUpdateTime(new Date());
            list.add(user);
        }
        var result = userMapper.saveBatchUser(list);
        return "插入条数: " + result;
    }

}