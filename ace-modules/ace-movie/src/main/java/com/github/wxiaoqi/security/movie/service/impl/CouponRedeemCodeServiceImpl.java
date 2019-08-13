package com.github.wxiaoqi.security.movie.service.impl;

import com.github.wxiaoqi.security.movie.entity.CouponRedeemCode;
import com.github.wxiaoqi.security.movie.mapper.CouponRedeemCodeMapper;
import com.github.wxiaoqi.security.movie.service.ICouponRedeemCodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CouponRedeemCodeServiceImpl extends ServiceImpl<CouponRedeemCodeMapper, CouponRedeemCode> implements ICouponRedeemCodeService {

    @Override
    public CouponRedeemCode getByCode(String code) {
        return null;
    }
}
