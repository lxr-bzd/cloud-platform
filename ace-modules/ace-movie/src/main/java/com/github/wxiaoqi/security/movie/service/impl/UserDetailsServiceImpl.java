package com.github.wxiaoqi.security.movie.service.impl;

import com.github.wxiaoqi.security.movie.entity.AuthUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @description
 * @author: lxr
 * @create: 2019-08-12 09:35
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        AuthUser authUser = new AuthUser();
        authUser.setUsername("abc");
        authUser.setPassword("123456");
        return authUser;
    }
}
