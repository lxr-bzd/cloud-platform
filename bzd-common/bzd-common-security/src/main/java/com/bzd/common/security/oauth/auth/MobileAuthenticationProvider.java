package com.bzd.common.security.oauth.auth;

import com.github.wxiaoqi.security.movie.entity.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

/**
 * @author lengleng
 * @date 2018/1/9
 * 手机号登录校验逻辑
 */
public class MobileAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MobileAuthenticationToken mobileAuthenticationToken = (MobileAuthenticationToken) authentication;
        //UserVo userVo = userService.findUserByMobile((String) mobileAuthenticationToken.getPrincipal());

        User userDetails = new User();


        MobileAuthenticationToken authenticationToken = new MobileAuthenticationToken(userDetails, new ArrayList<>());
        authenticationToken.setDetails(mobileAuthenticationToken.getDetails());
        return authenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MobileAuthenticationToken.class.isAssignableFrom(authentication);
    }


}