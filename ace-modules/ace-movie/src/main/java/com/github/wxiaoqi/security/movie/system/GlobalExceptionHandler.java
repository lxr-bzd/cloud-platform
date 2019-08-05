package com.github.wxiaoqi.security.movie.system;

import com.github.wxiaoqi.security.movie.system.bean.ResultCode;
import com.github.wxiaoqi.security.movie.system.bean.ResultData;
import com.github.wxiaoqi.security.movie.system.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description
 * @author: lxr
 * @create: 2019-08-03 18:01
 **/
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
    public ResultData exceptionHandler(Exception e) {

        e.printStackTrace();


        if(e instanceof ApplicationException){

            return ResultData.failResult(e.getMessage());
        }


        return ResultData.failResult("系统错误");
    }

}
