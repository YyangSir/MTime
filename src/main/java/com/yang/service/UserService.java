package com.yang.service;

import com.yang.entity.User;

import java.util.List;

/**
* @author Yyang
* @create2018/01/04
*/
public interface UserService extends Service<User> {

	/**
	 * 按名字查询用户
	 * @return
	 */
	List<User> selectByName(String name);
}
