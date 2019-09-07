package com.github.wxiaoqi.security.movie.controller;


import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.service.IUserService;
import com.github.wxiaoqi.security.movie.system.bean.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 15:08
 **/
@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    IUserService iUserService;


    @RequestMapping("/login")
    public ResultData login(User user){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User u = iUserService.verifyUser(user);

        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession().setAttribute("loginUsre",u);

        return ResultData.successResult();
    }


    @RequestMapping("/register")
    public ResultData register(User user){

        iUserService.registerUser(user);

        return ResultData.successResult();
    }









}
