package com.github.wxiaoqi.security.movie.service.impl;

import com.github.wxiaoqi.security.movie.entity.Coupon;
import com.github.wxiaoqi.security.movie.entity.CouponRedeemCode;
import com.github.wxiaoqi.security.movie.mapper.CouponMapper;
import com.github.wxiaoqi.security.movie.service.ICouponRedeemCodeService;
import com.github.wxiaoqi.security.movie.service.ICouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxiaoqi.security.movie.system.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {


    @Autowired
    ICouponRedeemCodeService iCouponRedeemCodeService;


    @Override
    public void gainByRedeemCode(Integer uid, String code) {

        CouponRedeemCode couponRedeemCode = iCouponRedeemCodeService.getByCode(code);
        if(couponRedeemCode==null)throw new ApplicationException("兑换码无效");


    }

    @Override
    public void useCoupon(Integer uid, Integer id) {


    }

}
