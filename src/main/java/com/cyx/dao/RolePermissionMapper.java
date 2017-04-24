package com.cyx.dao;

import java.util.List;

import com.cyx.po.RolePermission;

public interface RolePermissionMapper {
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<RolePermission> listAll();

}
