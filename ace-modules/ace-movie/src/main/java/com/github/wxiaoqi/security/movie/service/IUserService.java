package com.github.wxiaoqi.security.movie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.wxiaoqi.security.movie.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lxr
 * @since 2019-06-14
 */
public interface IUserService extends IService<User> {


     User verifyUser(User user);

     void registerUser(User user);

     User getByAccount(String account);


}
