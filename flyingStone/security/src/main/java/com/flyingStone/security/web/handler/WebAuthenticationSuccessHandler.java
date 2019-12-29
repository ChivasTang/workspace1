package com.flyingStone.security.web.handler;

import io.jsonwebtoken.lang.Assert;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public class WebAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    // logger設定
    private Logger logger = LoggerFactory.getLogger(getClass());

    // URLパラメータ
    private Map<String, String> urlMap;

    // 権限取得
    private boolean isFirst=true;

    @Resource
    private ObjectMapper objectMapper;

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.
     * AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("ログイン成功");
        Assert.notNull(urlMap,"AuthInterceptMap is null!");
        String url="";
        Collection<? extends GrantedAuthority> grantedAuthorities=authentication.getAuthorities();
        if(grantedAuthorities.isEmpty()){
            return;
        }

        //ログインユーザの最大権限を取得
        if(isFirst){
            GrantedAuthority[] ga=new GrantedAuthority[]{};
            url=urlMap.get(grantedAuthorities.toArray(ga)[0].toString());
            response.sendRedirect(request.getContextPath()+url);
        }else{
            for(GrantedAuthority auth:grantedAuthorities){
                url=urlMap.get(auth.getAuthority());
            }
            response.sendRedirect(url);
        }
    }

    /**
     * URLマップ
     * @param urlMap urlMap
     */
    public void setAuthDispatcherMap(Map<String, String> urlMap) {
        this.urlMap = urlMap;
    }

    /**
     * ロール判断
     * @param isFirst isFirst
     */
    public void setMultipleAuth(boolean isFirst) {
        this.isFirst = isFirst;
    }

}
