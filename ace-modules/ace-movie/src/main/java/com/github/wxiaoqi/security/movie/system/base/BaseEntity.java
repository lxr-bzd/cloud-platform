package com.github.wxiaoqi.security.movie.system.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 16:33
 **/
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

}
