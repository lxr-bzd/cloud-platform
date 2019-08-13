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
public class Coupon extends BaseEntity {

    private static final long serialVersionUID = 1L;

        /**
     * 优惠前名称
     */
         private String name;

        /**
     * 类型（1：续费券）
     */
         private Integer type;

        /**
     * 状态（1：待领取，2已领取）
     */
         private Integer state;

        /**
     * 使用状态（1：未使用，2：已使用）
     */
         private Integer useState;

    private Long starttime;

    private Long endtime;

        /**
     * 用户id
     */
         private Integer uid;


}
