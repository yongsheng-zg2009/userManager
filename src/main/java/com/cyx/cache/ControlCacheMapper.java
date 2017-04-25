package com.cyx.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.cyx.dao.GroupRoleMapper;
import com.cyx.dao.GroupUserMapper;
import com.cyx.dao.PermissionMapper;
import com.cyx.dao.RolePermissionMapper;
import com.cyx.dao.SystemRoleMapper;
import com.cyx.dao.UserMapper;
import com.cyx.po.Permission;
import com.cyx.po.RolePermission;

/**
 * 用户，权限控制缓存MAP
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月24日 下午9:47:25 
 * @mail yongsheng_zg2009@163.com
 */
public class ControlCacheMapper implements CommandLineRunner {
	
	/** 角色权限*/
	private final static Map<Integer, Map<Integer, Permission>> ROLE_PERMISSION_MAP = new HashMap<Integer, Map<Integer, Permission>>();

	/** 小组权限*/
	private final static Map<Integer, Map<Integer, Permission>> GROUP_PERMISSION_MAP = new HashMap<Integer, Map<Integer, Permission>>();

	/** 用户权限*/
	private final static Map<Integer, Map<Integer, Permission>> USER_PERMISSION_MAP = new HashMap<Integer, Map<Integer, Permission>>();
	
	/** 小组角色列表*/
	private final static Map<Integer, Map<Integer, String>> GROUP_ROLE_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	/** 用户的角色列表*/
	private final static Map<Integer, Map<Integer, String>> USER_ROLE_MAP = new HashMap<Integer, Map<Integer, String>>();
	
	
	/** 用户的小组列表*/
	private final static Map<Integer, Map<Integer, String>> USER_GROUP_MAP = new HashMap<Integer, Map<Integer, String>>();

	private final static Map<Integer, Permission>  SYS_PERMISSION_MAP = new HashMap<Integer, Permission>();
	
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private GroupRoleMapper groupRoleMapper;
	@Autowired
	private GroupUserMapper groupUserMapper;
	@Autowired
	private SystemRoleMapper systemRoleMapper;
	@Autowired
	private  UserMapper userMapper;
	
	
	@Override
	public void run(String... params) throws Exception {
		initPermissions(); 
	}
	
	public void initPermissions(){
		//TODO: 日志打印 开始--------------------------

		// 1、 获取系统所有的权限信息
		INIT_SYS_PERMISSION_MAP();
		
		// 2、获取所有的系统角色，并组装角色权限MAP
		INIT_ROLE_PERMISSION_MAP();
		
		// 3、获取所有的组，并组装组的权限， 组装组的角色
		
		// 4、获取所有的分组的用户，并组用户的权限，角色，以及组 
	}
	
	
	public void INIT_SYS_PERMISSION_MAP(){
		
		List<Permission> permissions = permissionMapper.listAll();
		if(null != permissions && !permissions.isEmpty()){
			for(Permission p : permissions){
				SYS_PERMISSION_MAP.put(p.getId(), p);
			}
		}
	}
	
	public void INIT_GROUP_ROLE_MAP(){
		
		List<RolePermission>  temList = rolePermissionMapper.listAll();
		RolePermission rp = null;
		if(null != temList && !temList.isEmpty()){
			for(int i = 0, size = temList.size(); i < size; i++ ){
				rp = temList.get(i);
				
				Map<Integer, Permission> map = ROLE_PERMISSION_MAP.get(rp.getRoleId());
			
				if(null == map) {
					map = new HashMap<Integer, Permission>();
					ROLE_PERMISSION_MAP.put(rp.getRoleId(), map);
				}
				map.put(rp.getPermissionId(), SYS_PERMISSION_MAP.get(rp.getPermissionId()));
			}
		}
	}
	
 
	
	
	
	public void INIT_ROLE_PERMISSION_MAP(){
		
		List<RolePermission>  temList = rolePermissionMapper.listAll();
		RolePermission rp = null;
		if(null != temList && !temList.isEmpty()){
			for(int i = 0, size = temList.size(); i < size; i++ ){
				rp = temList.get(i);
				
				Map<Integer, Permission> map = ROLE_PERMISSION_MAP.get(rp.getRoleId());
			
				if(null == map) {
					map = new HashMap<Integer, Permission>();
					ROLE_PERMISSION_MAP.put(rp.getRoleId(), map);
				}
				map.put(rp.getPermissionId(), SYS_PERMISSION_MAP.get(rp.getPermissionId()));
			}
		}
	}
	
	public static Map<Integer, Map<Integer, Permission>> ROLE_PERMISSION_MAP(){
		
		return ROLE_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, Permission>> GROUP_PERMISSION_MAP(){ 
		
		return GROUP_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, Permission>> USER_PERMISSION_MAP(){ 
		
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
