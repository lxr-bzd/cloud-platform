package com.github.wxiaoqi.security.movie.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 14:10
 **/
@Component
@Slf4j
public class TestTask {


    //@Scheduled(cron = "0/2 * * * * ?")
    public void test(){

        log.info("测试一下");

    }


}
