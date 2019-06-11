package com.avgd.user.serivce;


import com.avgd.user.mapper.UserMapper;
import com.avgd.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;

@Service
public class UserServer {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transient
    public void insertUser(User user){
        userMapper.insert(user);
    }

}
