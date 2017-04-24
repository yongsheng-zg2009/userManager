package com.cyx.service;

import java.util.List;
import java.util.Set;

import com.cyx.po.Permission;
import com.cyx.po.UserInfo;

/**
 * Created by mjg on 2017/4/13 0013.
 */
public interface UserService {
	
	/**
	 * 获取所有的用户
	 * 
	 * 不对外提供，做测试用的
	 */
	public List<UserInfo> userList();
	
	/**
	 * 获取用户的权限
	 * @param userName
	 */
	public List<Permission> getUserPermissions(String userName);
        
}
