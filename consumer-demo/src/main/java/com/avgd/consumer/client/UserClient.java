package com.avgd.consumer.client;

import com.avgd.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 服务远程调用
 */
@FeignClient(value = "user-service", fallback = UserClientFallback.class )
public interface UserClient {

    @GetMapping("user/{id}")
    User queryById(@PathVariable("id") Long id);

}
