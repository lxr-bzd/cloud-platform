package com.github.wxiaoqi.security.movie.config;

import com.github.wxiaoqi.security.movie.system.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description
 * @author: lxr
 * @create: 2019-06-13 13:32
 **/
@Configuration
public class WebConfig<addInterceptors> extends WebMvcConfigurationSupport {


    @Autowired
    TokenInterceptor tokenInterceptor;



    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations( "classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(tokenInterceptor).addPathPatterns("/api/**");

        super.addInterceptors(registry);
    }

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/details").setViewName("details");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/recharge").setViewName("recharge");
    }


}
