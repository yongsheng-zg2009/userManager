package com.cyx.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户，权限控制缓存MAP
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月24日 下午9:47:25 
 * @mail yongsheng_zg2009@163.com
 */
public class ControlCacheMapper {
	
	/** 角色权限*/
	private final static Map<Integer, Map<Integer, String>> ROLE_PERMISSION_MAP = new HashMap<Integer, Map<Integer, String>>();

	/** 小组权限*/
	private final static Map<Integer, Map<Integer, String>> GROUP_PERMISSION_MAP = new HashMap<Integer, Map<Integer, String>>();

	/** 用户权限*/
	private final static Map<Integer, Map<Integer, String>> USER_PERMISSION_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	
	
	/** 小组角色列表*/
	private final static Map<Integer, Map<Integer, String>> GROUP_ROLE_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	/** 用户的角色列表*/
	private final static Map<Integer, Map<Integer, String>> USER_ROLE_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	
	/** 用户的小组列表*/
	private final static Map<Integer, Map<Integer, String>> USER_GROUP_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	
	
	
	public static void init(){
		//TODO: 日志打印
		
		
		// 1、 获取系统所有的权限信息
		
		// 2、获取所有的系统角色，并组装角色权限MAP
		
		// 3、获取所有的组，并组装组的权限， 组装组的角色
		
		// 4、获取所有的分组的用户，并组用户的权限，角色，以及组
		
	}
	

	
	
	public static Map<Integer, Map<Integer, String>> ROLE_PERMISSION_MAP(){
		
		return ROLE_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, String>> GROUP_PERMISSION_MAP(){ 
		
		return GROUP_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, String>> USER_PERMISSION_MAP(){ 
		
		return USER_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, String>> GROUP_ROLE_MAP(){
		
		return GROUP_ROLE_MAP;
	}
	
	public static Map<Integer, Map<Integer, String>> USER_ROLE_MAP(){
		
		return USER_ROLE_MAP;
	}
	
	public static Map<Integer, Map<Integer, String>> USER_GROUP_MAP(){
		
		return USER_GROUP_MAP;
	}

	
	
	
	
	
	
}
