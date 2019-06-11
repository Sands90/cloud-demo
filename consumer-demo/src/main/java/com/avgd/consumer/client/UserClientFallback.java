package com.avgd.consumer.client;

import com.avgd.consumer.pojo.User;
import org.springframework.stereotype.Component;

/**
 * 服务降级熔断友好提示
 */
@Component
public class UserClientFallback implements UserClient {

    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("未知用户");
        return user;
    }
}
