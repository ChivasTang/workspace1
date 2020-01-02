package com.flyingStone.security.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 884767352117864856L;
    private String username;
    private String password;

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
