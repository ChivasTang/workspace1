package com.flyingStone.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
public class ParamDomain {
    private Long id;
    private String username;
}
