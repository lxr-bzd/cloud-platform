package com.github.wxiaoqi.security.movie.service;

import com.github.wxiaoqi.security.movie.entity.CouponRedeemCode;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
public interface ICouponRedeemCodeService extends IService<CouponRedeemCode> {

    CouponRedeemCode getByCode(String code);

}
