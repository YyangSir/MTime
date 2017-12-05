package com.yang.service.impl;

import com.yang.dao.UserDao;
import com.yang.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/11/5.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> userLogin(String number, String password) {
		if(number == null || password == null){
			return null;
		}
		return userDao.login(number, password);
	}

	@Override
	public List<Integer> checkname(String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		return userDao.checkname(name);
	}

	@Override
	public User register(User user) {
		user.setUserPhoto("head.jpg");
		//注册成功
		if (userDao.register(user)) {
			List<Integer> id=userDao.checkname(user.getUserName());
			user.setUserId(id.get(0));
			return user;
		}
		return null;
	}

}
