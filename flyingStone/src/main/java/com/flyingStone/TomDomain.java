package com.flyingStone;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TomDomain {
    private String htcNum;
    private String motoNo;
    private String motoCustNo;
    private String genNo;
    private String genCustNo;
}
