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

    public ParamDomain(Long id) {
        this.id = id;
    }

    public ParamDomain(String username) {
        this.username = username;
    }

    public ParamDomain(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}
