package com.flyingStone.core.dao;

import java.util.List;

import com.flyingStone.core.domain.entity.EmployeeEntity;

public interface EmployeeDao {

	List<EmployeeEntity> selectAll();
}
