package com.www.user.dao;

import org.springframework.stereotype.Repository;

import com.www.pojo.User;

@Repository
public interface UserDao {
	/**根据工作条形码获取用户**/
	public User getUserByWorkCode(String workCode) throws Exception;
}
