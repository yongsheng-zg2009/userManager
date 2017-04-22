package com.cyx.po;

import java.io.Serializable;

/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月11日 上午11:09:40 
 * @mail yongsheng_zg2009@163.com
 */
public class Permission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1335150924258377183L;
	
	
	private Integer id;
	//权限地址
	private String url;
	private String name;
	//权限基本别，默认是一级
	private Integer level = 1;
	
	// 父级权限id
	private String parentId;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	

}
