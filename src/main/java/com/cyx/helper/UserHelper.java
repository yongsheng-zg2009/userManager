package com.cyx.helper;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpRequest;

import com.cyx.cache.ControlCacheMapper;
import com.cyx.po.Permission;
import com.cyx.service.UserService;

public class UserHelper {
	
	private static UserService userService = (UserService) ApplicationHelper.getBean("userService");
	
	/**
	 * 用户是否
	 * @param userName
	 * @param url
	 * @return
	 */
	public static boolean hasPermission(HttpRequest request, String userName, String url){
		
		boolean hasPermission = false;
		
		if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(url)){
			
			Map<Integer, Permission> map =  ControlCacheMapper.USER_PERMISSION_MAP().get(userName);
			for(Permission p: map.values()){
				if(url.trim().equals(p.getUrl().trim())){
					hasPermission = true;
				}
			}
		}

		return hasPermission;
	}

	
}
