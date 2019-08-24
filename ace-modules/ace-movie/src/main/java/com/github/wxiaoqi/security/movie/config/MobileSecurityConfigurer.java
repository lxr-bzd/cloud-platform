package com.github.wxiaoqi.security.movie.config;

//**

import com.github.wxiaoqi.security.movie.system.oauth.auth.MobileAuthenticationFilter;
import com.github.wxiaoqi.security.movie.system.oauth.auth.MobileAuthenticationProvider;
import com.github.wxiaoqi.security.movie.system.oauth.auth.MobileLoginFailureHandler;
import com.github.wxiaoqi.security.movie.system.oauth.auth.MobileLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @author lengleng
 * @date 2018/1/9
 * 手机号登录配置入口
*/
@Component
public class MobileSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private MobileLoginSuccessHandler mobileLoginSuccessHandler;

    @Autowired
    private MobileLoginFailureHandler mobileLoginFailureHandler;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        MobileAuthenticationFilter mobileAuthenticationFilter = new MobileAuthenticationFilter();
        mobileAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        MobileAuthenticationProvider mobileAuthenticationProvider = new MobileAuthenticationProvider();
        mobileAuthenticationFilter.setAuthenticationSuccessHandler(mobileLoginSuccessHandler);
        mobileAuthenticationFilter.setAuthenticationFailureHandler(mobileLoginFailureHandler);
        //mobileAuthenticationProvider.setUserService(userDetailsService);
        http.authenticationProvider(mobileAuthenticationProvider)
                .addFilterAfter(mobileAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
