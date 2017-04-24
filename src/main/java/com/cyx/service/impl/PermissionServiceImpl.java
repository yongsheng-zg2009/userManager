package com.cyx.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyx.dao.PermissionMapper;
import com.cyx.po.Permission;
import com.cyx.service.PermissionService;


/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 下午1:39:43 
 * @mail yongsheng_zg2009@163.com
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public int insertPermission(Permission permission) {
		 
		return permissionMapper.insertPermission(permission);
	}

	@Override
	public List<Permission> listAll() {
		return permissionMapper.listAll();
	}

}
