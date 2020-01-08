package com.flyingStone.core.domain.common;

import com.flyingStone.core.domain.entity.RoleEntity;
import com.flyingStone.core.domain.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class AuthDomain {
    UserEntity user;
    List<RoleEntity> roles;
    List<GrantedAuthority> authorities;


    public AuthDomain(UserEntity user, List<GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }
}
