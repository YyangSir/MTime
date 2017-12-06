package com.yang.service;

import com.yang.entity.Remark;
import com.yang.entity.User;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/11/5.
 */
public interface UserService{
	/**
	 * 用户登陆
	 * @param number 手机号
	 * @param password 密码
	 * @return
	 */
	List<User> userLogin(String number,String password);

	/**
	 * 检查用户名重复
	 * @param name 用户名
	 * @return
	 */
	List<Integer> checkname(String name);

	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	User register(User user);

	/**
	 * 获取用户信息
	 * @param userid
	 * @return
	 */
	User info(int userid);

	/**
	 * 获取用户评论
	 * @param userid
	 * @return
	 */
	List<Remark> getUserRemark(int userid);
}
