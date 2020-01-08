package com.flyingStone.core.domain.common;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ParamsDomain {
    private Long id;
    private String username;
}
