package com.flyingStone.core.domain.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString(callSuper = true)
public class ParentDomain {

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Boolean delKbn;
}
