package com.cyx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cyx.po.Permission;

/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 上午11:48:28 
 * @mail yongsheng_zg2009@163.com
 * 
 * 系统资源权限的添加先用sql初始化搞定
 */
public interface PermissionMapper {
	
	//添加系统资源 
	public int inserPermission( @Param("permission") Permission permission);
	
	// 获取所有的系统资源
	public List<Permission> listAll();
}
