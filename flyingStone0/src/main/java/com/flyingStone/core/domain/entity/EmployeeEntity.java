package com.flyingStone.core.domain.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class EmployeeEntity {
	private Long empNo;
	private String name;
	private String job;
	private String mgr;
	private Date hireDate;
	private Double sal;

}
