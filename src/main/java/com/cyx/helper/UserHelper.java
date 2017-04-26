package com.cyx.helper;

import org.springframework.http.HttpRequest;

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
 
		//TODO:

		return false;
	}

	
}
