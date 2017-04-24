package com.cyx.dao;

import java.util.List;

import com.cyx.po.GroupUser;

public interface GroupUserMapper {
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<GroupUser> listAll();


}
