package com.github.wxiaoqi.security.movie.service.impl;

import com.github.wxiaoqi.security.movie.entity.User;
import com.github.wxiaoqi.security.movie.mapper.UserMapper;
import com.github.wxiaoqi.security.movie.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public void verifyUser(@Validated User user) {


    }
}
