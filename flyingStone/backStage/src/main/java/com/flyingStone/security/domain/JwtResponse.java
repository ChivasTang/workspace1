package com.flyingStone.security.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -2516722541134465269L;
    private final String jwtToken;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
