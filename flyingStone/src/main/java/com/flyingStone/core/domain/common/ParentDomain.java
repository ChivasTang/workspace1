package com.flyingStone.core.domain.common;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(callSuper = true)
public class ParentDomain {

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Boolean delKbn;
}
