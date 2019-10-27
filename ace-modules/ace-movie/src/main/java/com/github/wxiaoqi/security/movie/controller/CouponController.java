package com.github.wxiaoqi.security.movie.controller;


import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.feign.TestService;
import com.github.wxiaoqi.security.movie.service.ICouponService;
import com.github.wxiaoqi.security.movie.service.impl.CouponServiceImpl;
import com.github.wxiaoqi.security.movie.system.bean.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.github.wxiaoqi.security.movie.system.base.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/coupon")
public class CouponController extends BaseController {

    @Autowired
    ICouponService iCouponService;

    @Autowired
    TestService testService;


    @RequestMapping("/test")
    public ResultData test(User user){

        iCouponService.test();

        return ResultData.successResult();
    }


    @RequestMapping("/test2")
    public ResultData test2(User user){

        ( (CouponServiceImpl)iCouponService).test2();
        return ResultData.successResult();
    }
}

