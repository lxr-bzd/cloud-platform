package com.github.wxiaoqi.security.movie.entity;

import com.github.wxiaoqi.security.movie.system.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-14 17:01
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @NotEmpty(message = "账号不能为空")
    @Length(max = 20)
    private String account;


    @NotEmpty(message = "密码不能为空")
    private String pwd;




}
