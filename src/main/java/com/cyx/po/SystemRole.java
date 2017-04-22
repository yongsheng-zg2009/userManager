package com.cyx.po;

/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月11日 上午10:47:51 
 * @mail yongsheng_zg2009@163.com
 */
public class SystemRole {
	
	Integer id;
	private String code;
	private String name;
	private String parentId;
	private Integer level;

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
