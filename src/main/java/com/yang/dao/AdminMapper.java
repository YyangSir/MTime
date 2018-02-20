package com.yang.dao;

import com.yang.entity.Admin;
import com.yang.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper extends Mapper<Admin> {
	/**
	 * 管理员登陆
	 * @param name 手机号
	 * @param password 密码
	 * @return 用户列表
	 */
	@Select("select * from admin where name=#{name} and password=#{password}")
	List<Admin> login(@Param("name") String name, @Param("password") String password);
}