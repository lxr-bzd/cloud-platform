package com.github.wxiaoqi.security.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-13 11:46
 **/
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.github.wxiaoqi.security.movie.mapper")
public class MovieBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(MovieBootstrap.class, args);
    }

}
