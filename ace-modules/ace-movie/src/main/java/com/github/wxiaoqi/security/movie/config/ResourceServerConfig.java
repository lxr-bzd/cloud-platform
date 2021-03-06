package com.github.wxiaoqi.security.movie.config;

import com.github.wxiaoqi.security.movie.system.oauth.resource.AuthExceptionEntryPoint;
import com.github.wxiaoqi.security.movie.system.oauth.resource.CustomAccessDeniedHandler;
import com.github.wxiaoqi.security.movie.system.oauth.resource.HeaderTokenExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer //这个类表明了此应用是OAuth2 的资源服务器，此处主要指定了受资源服务器保护的资源链接
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    AuthExceptionEntryPoint authExceptionEntryPoint;

    @Autowired
    CustomAccessDeniedHandler customAccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        //resources.tokenExtractor(customTokenExtractor);
        resources.authenticationEntryPoint(authExceptionEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler);
        resources.tokenExtractor(new HeaderTokenExtractor());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();//禁用了 csrf 功能
        http.requestMatchers().mvcMatchers("/api/**","/decision/**");
        http.authorizeRequests()//限定签名成功的请求
                .antMatchers("/decision/**","/govern/**").hasAnyAuthority("USER")
                .antMatchers("/api/**").access("#oauth2.hasScope('read')")
                .antMatchers("/test/**").authenticated()
                .anyRequest().authenticated();;//必须认证过后才可以访问
                //.anyRequest().permitAll();//其他没有限定的请求，允许随意访问
                //.and().anonymous();//对于没有配置权限的其他请求允许匿名访问*/


    }

}