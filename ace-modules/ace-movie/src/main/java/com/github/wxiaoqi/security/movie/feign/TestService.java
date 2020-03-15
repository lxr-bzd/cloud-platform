package com.github.wxiaoqi.security.movie.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("bzd-eureka-config")
public interface  TestService {


    @GetMapping("/test")
    public String test( int id);

}
