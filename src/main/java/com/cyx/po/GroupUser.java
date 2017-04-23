package com.cyx.po;

import java.io.Serializable;

/**
 * 系统用户分配的组
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 上午11:36:19 
 * @mail yongsheng_zg2009@163.com
 */
public class GroupUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -521405925710031578L;
	
	private String userName;
	private String groupId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
