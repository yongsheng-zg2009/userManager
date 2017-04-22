package com.cyx.service.impl;

import com.cyx.dao.UserMapper;
import com.cyx.po.UserInfo;
import com.cyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    
    
    //TODO: 用户的权限
    
    //TODO： 用户所在分组列表
    
    //TODO: 用户的角色列表
    
    
}
