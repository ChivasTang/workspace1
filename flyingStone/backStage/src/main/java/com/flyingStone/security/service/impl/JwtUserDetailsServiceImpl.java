package com.flyingStone.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    /**
     * ユーザ名でユーザ情報を取得
     * @param username ユーザ名
     * @return 認証情報
     * @throws UsernameNotFoundException ユーザ存在しない
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Start"+this.getClass().getName());
        return null;
    }
}
