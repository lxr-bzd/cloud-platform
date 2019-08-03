package com.github.wxiaoqi.security.movie.controller;


import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.service.IUserService;
import com.github.wxiaoqi.security.movie.system.bean.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        iUserService.verifyUser(user);


        return ResultData.successResult();
    }


}
