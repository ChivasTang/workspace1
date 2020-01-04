package com.flyingStone.security.domain;

import com.flyingStone.security.constant.SecurityConstants;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = SecurityConstants.TOKEN_PREFIX;

    public JwtAuthenticationResponse(String accessToken){
        this.accessToken=accessToken;
    }
}
