package com.cyx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyx.po.Permission;

public interface PermissionService {
	
	//添加系统资源 
	public int inserPermission(@Param("permission") Permission permission);
	
	// 获取所有的系统资源
	public List<Permission> listAll();
 

}
