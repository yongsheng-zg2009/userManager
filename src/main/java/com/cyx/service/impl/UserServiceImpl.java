package com.cyx.service.impl;

import com.cyx.dao.UserMapper;
import com.cyx.po.Permission;
import com.cyx.po.UserInfo;
import com.cyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
@Service("userService")
public class UserServiceImpl  implements UserService{
	
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public List<UserInfo> userList() {
        return userMapper.userList();
    }
    

	@Override
	public List<Permission> getUserPermissions(String userName) {
		
		//TODO: 1、获取我的组列表
		
		//TODO: 2、获取各个组对应的角色类别
		
		//TODO: 3、各个角色的权限列表
		
		//TODO: 4、组装，用户的权限列表
		

		return null;
	}
    
    
    //TODO: 用户的权限
    
    //TODO： 用户所在分组列表
    
    //TODO: 用户的角色列表
    
    
}
