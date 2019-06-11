package com.avgd.consumer.controller;

import com.avgd.consumer.client.UserClient;
import com.avgd.consumer.pojo.User;
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "queryByIdFallback") // 通用的降级方法提示错误信息
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private RibbonLoadBalancerClient client;


    /**
     * 服务降级
     * 3秒钟没输出则触发服务降级提示
     *//*
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("{id}")
    public String queryById(@PathVariable("id") Long id){

        if(id % 2 == 0){
            throw new RuntimeException("");
        }

        String url = "http://user-service/user/" + id;
        String user = restTemplate.getForObject(url,String.class);
        return user;
    }*/

   /* *//**
     * 服务降级熔断
     * @HystrixCommand 服务器降级熔断配置
     * requestVolumeThreshold: 触发熔断的最小请求次数，默认20
     * sleepWindowInMilliseconds：触发熔断的失败请求最小占比，默认为50%
     * errorThresholdPercentage：休眠时长，默认为5000毫秒
     *//*
    @GetMapping("{id}")
    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "60")
            }
    )
    public String queryById(@PathVariable("id") Long id){
        // 手动触发熔断测试
        if(id % 2 == 0){
            throw new RuntimeException("");
        }

        String url = "http://user-service/user/" + id;
        String user = restTemplate.getForObject(url,String.class);
        return user;
    }*/

    /**
     * Feign远程调用
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        return userClient.queryById(id);
    }

    public String queryByIdFallback(@PathVariable("id") Long id){
        log.debug("服务器忙，请稍后再试！");
        return "服务器忙，请稍后再试！";
    }

    public String queryByIdFallback(){
        log.debug("服务器忙，请稍后再试！");
        return "服务器忙，请稍后再试！";
    }

   /* @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
       *//* List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance instance = instances.get(0);
//        String url = "http://localhost:8081/user/" + id;*//*
       *//* ServiceInstance instance = client.choose("user-service");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;*//*
        String url = "http://user-service/user/" + id;
        System.out.println("url = " + url);
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }*/



}
