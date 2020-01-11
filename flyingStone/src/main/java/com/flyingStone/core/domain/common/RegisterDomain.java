package com.flyingStone.core.domain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class RegisterDomain {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
}
