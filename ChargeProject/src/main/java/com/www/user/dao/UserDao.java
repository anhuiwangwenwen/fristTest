package com.www.user.dao;

import org.springframework.stereotype.Repository;

import com.www.pojo.User;

@Repository
public interface UserDao {
	/**���ݹ����������ȡ�û�**/
	public User getUserByWorkCode(String workCode) throws Exception;
}
