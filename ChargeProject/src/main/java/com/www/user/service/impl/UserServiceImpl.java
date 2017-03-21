package com.www.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.www.pojo.User;
import com.www.user.dao.UserDao;
import com.www.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByWorkCode(String workCode) throws Exception {
		return userDao.getUserByWorkCode(workCode);
	}

}
