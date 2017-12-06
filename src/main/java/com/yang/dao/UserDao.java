package com.yang.dao;

import com.yang.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/10/31.
 */
public interface UserDao {

	/**
	 * 保存用户 注册
	 * @param user 保存的用户
	 * @return 是否保存成功
	 */
	@Insert("insert into users(userNumber,userName,password,userPhoto)" +
			"values(#{userNumber},#{userName},#{password},#{userPhoto})")
	@Options(useGeneratedKeys=true, keyProperty="user.userId")
	boolean register(User user);

	/**
	 * 通过用户名查询用户id
	 * @param userName
	 * @return
	 */
	@Select("select userId from users where userName=#{userName}")
	List<Integer> checkname(@Param("userName") String userName);

	/**
	 * 查找用户 登陆
	 * @param number 手机号
	 * @param password 密码
	 * @return 用户列表
	 */
	@Select("select * from users where userNumber=#{userNumber} and password=#{password}")
	List<User> login(@Param("userNumber") String number, @Param("password") String password);

	/**
	 * 通过id查找用户
	 * @param userid
	 * @return
	 */
	@Select("select * from users where userId=#{id}")
	List<User> selectUserById(@Param("id") int userid);


	/**
	 * 修改用户昵称
	 * @param userName
	 * @param userId
	 * @return
	 */
	@Update("update users set userName=#{userName} where userId=#{userId}")
	boolean updateName(@Param("userName") String userName, @Param("userId") String userId);

	/**
	 * 修改用户头像
	 * @param userPhoto 用户头像
	 * @param userId 用户id
	 * @return 是否修改成功
	 */
	@Update("update users set userPhoto=#{userPhoto} where userId=#{userId}")
	boolean updatePhoto(@Param("userPhoto") String userPhoto, @Param("userId") String userId);

}
