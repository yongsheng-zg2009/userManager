package com.cyx.dao;

import java.util.List;

import com.cyx.po.RrolePermission;

public interface RolePermissionMapper {
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<RrolePermission> listAll();

}
