package com.github.wxiaoqi.security.movie.service;

import com.github.wxiaoqi.security.movie.entity.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
public interface ICouponService extends IService<Coupon> {


    /**
     * 兑换码获取会员券
     * @param uid
     * @param code
     */
    void gainByRedeemCode(Integer uid,String code);


    /**
     * 使用会员券
     * @param uid
     * @param id
     */
    void useCoupon(Integer uid,Integer id);

}
