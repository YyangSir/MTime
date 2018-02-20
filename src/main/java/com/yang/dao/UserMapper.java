package com.yang.dao;

import com.yang.entity.User;
import com.yang.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends Mapper<User> {
	/**
	 * 按名字,手机号查询用户
	 * @param name
	 * @return
	 */
	@Select("select * from user where " +
			"nickName like concat(concat('%',#{name}),'%') " +
			"or number like concat(concat('%',#{name}),'%') ")
	List<User> selectByName(String name);
}