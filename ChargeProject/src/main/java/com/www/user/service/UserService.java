package com.www.user.service;

import com.www.pojo.User;

public interface UserService {
	/**���ݹ����������ȡ�û�**/
	public User getUserByWorkCode(String workCode) throws Exception;
}
