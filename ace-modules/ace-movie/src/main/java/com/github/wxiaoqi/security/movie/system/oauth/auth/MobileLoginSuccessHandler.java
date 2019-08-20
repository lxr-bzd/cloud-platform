package com.github.wxiaoqi.security.movie.system.oauth.auth;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author lengleng
 * @date 2018/1/8
 * 手机号登录成功，返回oauth token
 */
@Component
public class MobileLoginSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
   /* @Autowired
    private ObjectMapper objectMapper;*/
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private static ApplicationContext applicationContext;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Basic ")) {
            throw new UnapprovedClientAuthenticationException("请求头中client信息为空");
        }

        try {
            //String[] tokens = extractAndDecodeHeader(header);
            //assert tokens.length == 2;
            String clientId = request.getParameter("client_id");
            //String clientSecret = tokens[1];

            /*JSONObject params = new JSONObject();
            params.put("clientId", clientId);
            params.put("clientSecret", clientSecret);
            params.put("authentication", authentication);*/

            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            TokenRequest tokenRequest = new TokenRequest(new HashMap<>(), clientId, clientDetails.getScope(), "mobile");
            OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);

            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
            OAuth2AccessToken oAuth2AccessToken = getAuthorizationServerTokenServices().createAccessToken(oAuth2Authentication);
            logger.info("获取token 成功：{}", oAuth2AccessToken.getValue());


            PrintWriter printWriter = response.getWriter();
            printWriter.append(JSONObject.toJSONString(oAuth2AccessToken));
        } catch (IOException e) {
            throw new BadCredentialsException(
                    "Failed to decode basic authentication token");
        }
    }

    public AuthorizationServerTokenServices getAuthorizationServerTokenServices(){

        return applicationContext.getBean(AuthorizationServerTokenServices.class);
    }

}
