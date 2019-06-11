package com.avgd.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    /*@Autowired
    private DataSource dataSource;*/

    @GetMapping("hello")
    public String hello(){
       log.debug("hello method is running");
        return "hello springboot!";
    }

}
