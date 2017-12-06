package com.yang.service.impl;

import com.yang.dao.RemarkDao;
import com.yang.dao.UserDao;
import com.yang.entity.Remark;
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
	@Autowired
	private RemarkDao remarkDao;

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
			return user;
		}
		return null;
	}

	@Override
	public User info(int userid) {
		List<User> users = userDao.selectUserById(userid);
		if (users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<Remark> getUserRemark(int userid) {
		List<Remark> remarks = remarkDao.getUserRemark(userid);
		int n = remarks.size();
		for(int i=0;i<n;i++) {
			remarks.get(i).setRemarkData(remarks.get(i).getRemarkTime().toString());
		}
		return remarks;
	}

}
