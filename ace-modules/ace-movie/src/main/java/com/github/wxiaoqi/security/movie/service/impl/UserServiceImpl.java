package com.github.wxiaoqi.security.movie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.mapper.UserMapper;
import com.github.wxiaoqi.security.movie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxiaoqi.security.movie.system.exception.ApplicationException;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lxr
 * @since 2019-06-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User verifyUser(@Validated User user) {

        User u = getByAccount(user.getAccount());
        if(u==null||!u.getPwd().equals(encryption(user.getPwd())))throw new ApplicationException("账号或密码错误");
        return u;
    }

    @Override
    public void registerUser(@Validated User user) {

        if(StringUtils.isBlank(user.getName()))user.setName("用户"+ RandomUtils.nextInt(100000,999999));

        if(getByAccount(user.getAccount())!=null)throw new ApplicationException("账户已存在");

        user.setPwd(encryption(user.getPwd()));

        this.save(user);
    }

    @Override
    public User getByAccount(String account) {

        QueryWrapper qw = new QueryWrapper();
        qw.eq("account",account);
       return  this.getOne(qw);
    }


    private String encryption(String pwd){

        return pwd;

    }


}
