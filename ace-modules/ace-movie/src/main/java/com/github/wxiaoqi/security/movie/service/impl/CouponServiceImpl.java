package com.github.wxiaoqi.security.movie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.wxiaoqi.security.movie.entity.Coupon;
import com.github.wxiaoqi.security.movie.entity.CouponRedeemCode;
import com.github.wxiaoqi.security.movie.mapper.CouponMapper;
import com.github.wxiaoqi.security.movie.service.ICouponRedeemCodeService;
import com.github.wxiaoqi.security.movie.service.ICouponService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxiaoqi.security.movie.system.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public void test() {
        QueryWrapper qw = new QueryWrapper();
        Coupon coupon = this.getOne(qw);

        System.out.println("1：进入");
        Integer type = coupon.getType();
        System.out.println("1：获取"+type);


        coupon.setType(1);
        this.updateById(coupon);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1：更新："+coupon.getType());

    }

    @Transactional
    public void test2() {
        QueryWrapper qw = new QueryWrapper();
        Coupon coupon = this.getOne(qw);

        System.out.println("2:进入");
        Integer type = coupon.getType();
        System.out.println("2：获取"+type);

        coupon.setType(2);
        this.updateById(coupon);
        System.out.println("2：更新："+coupon.getType());

    }

}
