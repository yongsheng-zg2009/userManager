package com.cyx.po;

import java.io.Serializable;

public class GroupInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8432870038457884008L;
	
	
	private Integer id;
	//权限地址
	private String code;
	private String name;
	//组别，默认是一个组
	private Integer level = 1;
	
	// 父级权限id
	private String parentId;

	private String brief;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}
	
	

}
