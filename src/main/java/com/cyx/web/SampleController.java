package com.cyx.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyx.po.UserInfo;
import com.cyx.service.PermissionService;
import com.cyx.service.UserService;

@RestController
//@EnableAutoConfiguration
public class SampleController {
	
    @Autowired
    public UserService userService;
    @Autowired
    public PermissionService permissionService;
    
    @RequestMapping("/")
    List<UserInfo> home() {
        return userService.userList();
    }
    
    
    @RequestMapping("/1/")
    Object test1(){
    	
    	return permissionService.listAll();
    }
}