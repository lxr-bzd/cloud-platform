package com.github.wxiaoqi.security.movie.controller;


import com.github.wxiaoqi.security.movie.system.bean.ResultData;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.github.wxiaoqi.security.movie.system.base.BaseController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
@RestController
@RequestMapping("/coupon-redeem-code")
public class CouponRedeemCodeController extends BaseController {


    @RequestMapping("getCouponByCode")
    public ResultData getCouponByCode(Map map){



        return ResultData.successResult();

    }


}

