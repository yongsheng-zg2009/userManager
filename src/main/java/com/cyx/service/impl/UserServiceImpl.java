package com.cyx.service.impl;

import com.cyx.dao.UserMapper;
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
    public List userList() {
        return userMapper.userList();
    }
}
