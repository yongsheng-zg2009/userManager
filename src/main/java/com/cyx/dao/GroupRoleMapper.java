package com.cyx.dao;

import java.util.List;

import com.cyx.po.GroupRole;

public interface GroupRoleMapper {
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<GroupRole> listAll();

}
