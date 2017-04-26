package com.cyx.dao;

import java.util.List;

import com.cyx.po.SystemRole;

/**
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月23日 上午11:49:44 
 * @mail yongsheng_zg2009@163.com
 */
public interface SystemRoleMapper {
	
	
	/**
	 * 获取所有的组
	 * @return
	 */
	public List<SystemRole> listAll();
	
	
}
