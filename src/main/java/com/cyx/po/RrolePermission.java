package com.cyx.po;

import java.io.Serializable;

/**
 * @DES 角色拥有的权限
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 上午11:36:49 
 * @mail yongsheng_zg2009@163.com
 */
public class RrolePermission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2372614263406731550L;
	
	Integer permissionId;
	Integer roleId;
	
	
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
