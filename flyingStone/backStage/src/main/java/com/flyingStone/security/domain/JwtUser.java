package com.flyingStone.security.domain;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flyingStone.core.domain.entity.RoleEntity;
import com.flyingStone.core.domain.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {
	
	private static final long serialVersionUID = -2970656508922275934L;

	private Long userId;
	private String username;
    @JsonIgnore
	private String email;
	@JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long userId, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static JwtUser create(UserEntity user, List<RoleEntity> roles){
        List<GrantedAuthority> authorities=roles.stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
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
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        JwtUser that=(JwtUser)obj;
        return Objects.equals(userId,that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
