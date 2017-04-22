package com.cyx.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基本信息
 * @author yongsheng
 *
 */

public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6563393723571589278L;
	
	private String userName;// 用户名
	private String nickName;
	private String gender; // 性别
	private Integer age;
	private Date dtRegisterTime;
	private Date dtCreateTime;
	private Date dtLastUpdateTime;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDtRegisterTime() {
		return dtRegisterTime;
	}

	public void setDtRegisterTime(Date dtRegisterTime) {
		this.dtRegisterTime = dtRegisterTime;
	}

	public Date getDtCreateTime() {
		return dtCreateTime;
	}

	public void setDtCreateTime(Date dtCreateTime) {
		this.dtCreateTime = dtCreateTime;
	}

	public Date getDtLastUpdateTime() {
		return dtLastUpdateTime;
	}

	public void setDtLastUpdateTime(Date dtLastUpdateTime) {
		this.dtLastUpdateTime = dtLastUpdateTime;
	}

	
 
}
