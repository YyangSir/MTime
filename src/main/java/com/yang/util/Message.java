package com.yang.util;

import com.yang.entity.Movie;
import com.yang.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yyang
 * @create 2017/11/9.
 */
public class Message {

	/**
	 * 返回信息
	 * @param is 是否成功
	 * @param user 用户信息
	 * @param authority 管理员姓名
	 * @return
	 */
	public static Map message(boolean is, User user, String authority) {
		Map<String, String> map = message(is,user);
		map.put("authority", authority);
		return map;
	}

	/**
	 *
	 * @param is 是否成功
	 * @param user 用户信息
	 * @return
	 */
	public static Map message(boolean is, User user) {
		Map<String, String> map = message(is);
		//向前端发送的信息
		map.put("name", user.getUserName());
		map.put("img", user.getUserPhoto());
		map.put("id", user.getUserId()+"");
		map.put("number", user.getUserNumber());
		return map;
	}

	/**
	 * 自定义消息通知
	 * @param is
	 * @param msgK 消息key
	 * @param msgV 消息内容
	 * @return
	 */
	public static Map message(boolean is, String msgK,String msgV) {
		Map<String, String> map = message(is);
		map.put(msgK, msgV);
		return map;
	}

	/**
	 *
	 * @param is 是否成功
	 * @return
	 */
	public static Map message(boolean is) {
		String msg = "";
		if(is){
			msg = "success";
		} else {
			msg = "error";
		}
		Map<String, String> map = new HashMap<>(5);
		map.put("msg", msg);
		return map;
	}


}
