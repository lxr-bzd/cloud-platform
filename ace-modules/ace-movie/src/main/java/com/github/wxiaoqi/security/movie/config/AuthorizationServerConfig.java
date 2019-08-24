package com.github.wxiaoqi.security.movie.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

// 提供/oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access,/oauth/error
@Configuration
@EnableAuthorizationServer // 这个注解告诉 Spring 这个应用是 OAuth2 的授权服务器//
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {



    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired()
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public TokenStore tokenStore() {
       //return new InMemoryTokenStore(); //使用内存中的 token store
       return new JdbcTokenStore(dataSource); ///使用Jdbctoken store
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // authorization_code
        //password
        //client_credentials
        //implicit
        //refresh_ token
        clients.inMemory()
                .withClient("client1")
                .secret(bCryptPasswordEncoder().encode("123456"))
                .authorizedGrantTypes("password", "refresh_token")//允许授权范围
                .authorities("ADMIN","ROLE_USER")//客户端可以使用的权限
                .scopes( "read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(7200);
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.tokenStore(tokenStore())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);//必须设置 UserDetailsService 否则刷新token 时会报错

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();//允许表单登录

    }
}