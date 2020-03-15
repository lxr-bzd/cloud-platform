package com.bzd.eureka.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    private Object test(Integer id){


        return id+"==="+toString();
    }
}
