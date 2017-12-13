package com.yang.contrller;

import com.yang.entity.Remark;
import com.yang.entity.User;
import com.yang.service.UserService;
import com.yang.util.ImgUtil;
import com.yang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author Yyang
 * @create 2017/10/23.
 */
@RestController
public class UserContrller {
	private static int ADMIN_ID = 5;
	@Autowired
	UserService userService;

	/**
	 * 登陆
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/login",method = RequestMethod.POST)
	public Map login(HttpSession session, User user) {
		System.out.println("login...");

		List<User> list = userService.userLogin(user.getUserNumber(), user.getPassword());

		//判断登陆成功
		if (list.size() > 0) {
			int id = list.get(0).getUserId();
			session.setAttribute("id", id );
			String name = list.get(0).getUserName();
			//管理员 或普通用户
			if (id <= ADMIN_ID) {
				return Message.message(true, list.get(0), "admin");
			} else {
				return Message.message(true, list.get(0));
			}
		} else {
			return Message.message(false);
		}
	}

	/**
	 * 注册
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user/register",method = RequestMethod.POST)
	public Map register(HttpSession session, User user) {
		System.out.println("Register...");
		int numberLength = 11;
		//信息不为空
		if (user.getUserName() == null || user.getUserNumber() == null || user.getPassword() == null) {
			return Message.message(false);
		}
		//信息不合法
		if (user.getUserNumber().length() != numberLength) {
			return Message.message(false);
		}
		//注册成功
		if (userService.register(user)!= null) {
			//保存session 评论拦截
			session.setAttribute("id", user.getUserId());
			//返回信息 成功+用户名信息
			return Message.message(true, user);
		} else {
			//注册失败
			return Message.message(false);
		}
	}

	/**
	 * 检查用户名重复
	 * @param user
	 * @return msg 重复
	 */
	@RequestMapping(value = "/user/checkname",method = RequestMethod.POST)
	public Map checkname(User user) {
		System.out.println("checkname...");
		String name = user.getUserName();
		if (name != null) {
			List<Integer> id= userService.checkname(name);
			if (id.size()>0) {
				//用户名已存在 返回true
				return Message.message(true);
			}else {
				return Message.message(false);
			}
		}
		return Message.message(false);
	}

	/**
	 * 获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/info/{id}", method = RequestMethod.GET)
	public Map info(@PathVariable("id") String id) {
		if (id == null || id.isEmpty()) {
			return Message.message(false);
		}
		int userId = Integer.parseInt(id);
		User user = userService.info(userId);
		if ( user!= null) {
			return Message.message(true, user);
		}
		return Message.message(false);
	}

	/**
	 * 获取用户评论
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/remark/{id}", method = RequestMethod.GET)
	public List<Remark> remarks(@PathVariable("id") String id) {
		int userId = Integer.parseInt(id);
		return userService.getUserRemark(userId);
	}

	/**
	 * 更换头像
	 * @param img
	 * @return
	 */
	@RequestMapping(value = "/user/UserPhoto", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map uploadImg(@RequestParam(value = "img") MultipartFile img,HttpSession session) {
		if (img == null) {
			return Message.message(false);
		}

		//保存图片
		try {
			String userPhoto = ImgUtil.savrPhoto(img);
			if (userPhoto != null) {
				int id = (int) session.getAttribute("id");
				if (userService.updateUserPhoto(userPhoto, id)) {
					return Message.message(true,"userPhoto",userPhoto);
				}
			}
		} catch (Exception e) {

		}
		return Message.message(false);
	}
}
