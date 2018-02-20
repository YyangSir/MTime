package com.yang.service;


import com.yang.entity.Actor;

import java.util.List;

/**
* @author Yyang
* @create2018/01/24
*/
public interface ActorService extends Service<Actor> {

	/**
	 * 通过演员名查询
	 * @param name
	 * @return
	 */
	List<Actor> selectByName(String name);
}
