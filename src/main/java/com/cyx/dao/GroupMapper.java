package com.cyx.dao;

import java.util.List;

import com.cyx.po.GroupInfo;

/**
 *  系统用户分组
 * @author niyongsheng
 * @version 创建时间：2017年4月24日 下午8:25:10 
 * @mail yongsheng_zg2009@163.com
 */
public interface GroupMapper {
	
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<GroupInfo> listAll();
}
