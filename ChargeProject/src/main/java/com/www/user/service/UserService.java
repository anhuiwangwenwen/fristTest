package com.www.user.service;

import com.www.pojo.User;

public interface UserService {
	/**根据工作条形码获取用户**/
	public User getUserByWorkCode(String workCode) throws Exception;
}
