package com.cyx.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cyx.dao.GroupRoleMapper;
import com.cyx.dao.GroupUserMapper;
import com.cyx.dao.PermissionMapper;
import com.cyx.dao.RolePermissionMapper;
import com.cyx.dao.SystemRoleMapper;
import com.cyx.dao.UserMapper;
import com.cyx.po.GroupRole;
import com.cyx.po.GroupUser;
import com.cyx.po.Permission;
import com.cyx.po.RolePermission;

/**
 * 用户，权限控制缓存MAP
 * 
 * @author niyongsheng
 * @version 创建时间：2017年4月24日 下午9:47:25 
 * @mail yongsheng_zg2009@163.com
 */
@Component
public class ControlCacheMapper implements CommandLineRunner {
	
	 
	
	/** 角色权限*/
	private final static Map<Integer, Map<Integer, Permission>> ROLE_PERMISSION_MAP = new HashMap<Integer, Map<Integer, Permission>>();

	/** 小组权限*/
	private final static Map<Integer, Map<Integer, Permission>> GROUP_PERMISSION_MAP = new HashMap<Integer, Map<Integer, Permission>>();

	/** 用户权限*/
	private final static Map<String, Map<Integer, Permission>> USER_PERMISSION_MAP = new HashMap<String, Map<Integer, Permission>>();
	
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
		System.out.println("ControlCacheMapper数据输入：------------------------");
		// 1、 将系统中的权限加载到内存
		INIT_SYS_PERMISSION_MAP();
		// 2、将角色的权限加载到内存
		INIT_ROLE_PERMISSION_MAP();
		// 3、将组的权限加载到内存
		INIT_GROUP_PERMISSION_MAP();
		// 4、将用户的权限加载到内存中
		INIT_USER_PERMISSION_MAP();
		System.out.println("ControlCacheMapper数据输入：------------------------end");
	}
	
	/**
	 * 将系统的资源加载到内存
	 */
	private void INIT_SYS_PERMISSION_MAP(){
		
		List<Permission> permissions = permissionMapper.listAll();
		if(null != permissions && !permissions.isEmpty()){
			for(Permission p : permissions){
				SYS_PERMISSION_MAP.put(p.getId(), p);
			}
		}
	}
	
	/**
	 * 将角色的权限加载到内存
	 */
	public void INIT_ROLE_PERMISSION_MAP(){
		
		List<RolePermission>  temList = rolePermissionMapper.listAll();
		RolePermission rp = null;
		if(null != temList && !temList.isEmpty()){
			for(int i = 0, size = temList.size(); i < size; i++ ){
				rp = temList.get(i);
				Map<Integer, Permission> valMap = ROLE_PERMISSION_MAP.get(rp.getRoleId());
				if(null == valMap) {
					valMap = new HashMap<Integer, Permission>();
					ROLE_PERMISSION_MAP.put(rp.getRoleId(), valMap);
				}
				valMap.put(rp.getPermissionId(), SYS_PERMISSION_MAP.get(rp.getPermissionId()));
			}
		}
	}

	/**
	 * 将组的权限加载到内存
	 */
	public void INIT_GROUP_PERMISSION_MAP(){
		
		List<GroupRole> list = groupRoleMapper.listAll();
		
		// 一个组拥有哪些权限
		GroupRole gr = null;
		if(null != list && !list.isEmpty()){
			for(int i = 0, size = list.size(); i < size; i ++ ){
				gr = list.get(i);

				Map<Integer, Permission> valMap = GROUP_PERMISSION_MAP.get(gr.getRoleId());
				
				if(valMap != null){
					valMap = new HashMap<Integer, Permission>();
					GROUP_PERMISSION_MAP.put(gr.getGroupId(), valMap);
				}
				valMap.putAll(ROLE_PERMISSION_MAP.get(gr.getRoleId())); 
			}
		}
	}
	
	private void INIT_USER_PERMISSION_MAP(){
		
		
		List<GroupUser> list = groupUserMapper.listAll();
		GroupUser gu = null;
		if(null != list && !list.isEmpty()){
			for(int i = 0, size = list.size(); i < size; i ++ ){
				gu = list.get(i);
				Map<Integer, Permission> map = USER_PERMISSION_MAP.get(gu.getGroupId());
				
				if(map != null){
					map = new HashMap<Integer, Permission>();
					USER_PERMISSION_MAP.put(gu.getUserName(), map);
				}
				map.putAll(GROUP_PERMISSION_MAP.get(gu.getGroupId())); 
			}
		}
		
	}
	
	public static Map<Integer, Map<Integer, Permission>> ROLE_PERMISSION_MAP(){
		
		return ROLE_PERMISSION_MAP;
	}
	
	public static Map<Integer, Map<Integer, Permission>> GROUP_PERMISSION_MAP(){ 
		
		return GROUP_PERMISSION_MAP;
	}
	
	public static Map<String, Map<Integer, Permission>> USER_PERMISSION_MAP(){ 
		
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
