package com.flyingStone.authorize.service.impl;

import com.flyingStone.authorize.service.RbacService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

@Service("rbacService")
public class RbacServiceImpl implements RbacService {
    private AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        Object principle=authentication.getPrincipal();
        boolean hasPermission=false;

        if(principle instanceof UserDetails){
            String username=((UserDetails)principle).getUsername();

            //TODO 全てアクセスできるURLを取得
            Set<String> urls=new HashSet<>();

            for(String url: urls){
                if(antPathMatcher.match(url,request.getRequestURI())){
                    hasPermission=true;
                    break;
                }
            }
        }
        return false;
    }
}
