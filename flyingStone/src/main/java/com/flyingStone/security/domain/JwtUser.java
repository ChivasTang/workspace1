package com.flyingStone.security.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.flyingStone.core.domain.common.ParentDomain;

public class JwtUser extends ParentDomain implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long userId;
    private String username;
    private String password;
    List<GrantedAuthority> authorities;


    public JwtUser(Long userId, String username, String password, List<GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getUserId(){
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !super.getDelKbn();
    }
}
