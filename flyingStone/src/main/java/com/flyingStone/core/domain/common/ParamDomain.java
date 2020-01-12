package com.flyingStone.core.domain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class ParamDomain extends ParentDomain {
    private Long id;
    private String username;
    private String password;
    private String email;


    public ParamDomain() { }
    public ParamDomain(Long id) {
        this.id = id;
    }
    public ParamDomain(String username) {
        this.username = username;
    }
    public ParamDomain(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


}
