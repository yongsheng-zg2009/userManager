package com.cyx.po;

import java.io.Serializable;

public class GroupRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8869101892657338358L;

	private Integer groupId;
	
	private Integer roleId;
	

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	
	
}
