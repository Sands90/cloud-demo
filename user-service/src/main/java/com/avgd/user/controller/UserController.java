package com.avgd.user.controller;

import com.avgd.user.pojo.User;
import com.avgd.user.serivce.UserServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServer userServer;


    @GetMapping("{id}")
    public User user(@PathVariable("id") Long id){
        return userServer.queryById(id);
    }
}
