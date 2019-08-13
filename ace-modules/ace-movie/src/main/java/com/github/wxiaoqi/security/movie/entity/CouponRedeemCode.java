package com.github.wxiaoqi.security.movie.entity;

import com.github.wxiaoqi.security.movie.system.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lxr
 * @since 2019-08-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CouponRedeemCode extends BaseEntity {

    private static final long serialVersionUID = 1L;

        /**
     * 兑换码
     */
         private Integer code;

        /**
     * 券id
     */
         private Integer couponId;

        /**
     * 是否使用
     */
         private Integer isUse;


}
