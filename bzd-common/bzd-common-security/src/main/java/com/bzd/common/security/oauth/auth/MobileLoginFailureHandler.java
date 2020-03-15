package com.bzd.common.security.oauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description
 * @author: lxr
 * @create: 2019-08-24 15:50
 **/
@Component
public class MobileLoginFailureHandler implements AuthenticationFailureHandler {


    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;


    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {


        authenticationEntryPoint.commence(httpServletRequest,httpServletResponse,e);

    }
}
