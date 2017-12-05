package com.yang.contrller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yyang
 * @create 2017/11/9.
 * 跳转控制
 */
@Controller
public class JumpContrller {

	/**
	 * 主页
	 * @return
	 */
	@RequestMapping( value = {"/","/index","/home"})
	public String index() {
		System.out.println("首页");
		return"index";
	}

	/**
	 * 去电影列表
	 * @return
	 */
	@RequestMapping("/tolist")
	public String toList() {
		System.out.println("电影列表");
		return "movie-list";
	}

	/**
	 * 去评论页
	 * @return
	 */
	@RequestMapping("/toremark")
	public String toRemark() {
		System.out.println("评论");
		return "remark";
	}

	/**
	 * 去我的电影
	 * @return
	 */
	@RequestMapping("/tomy")
	public String toMy() {
		System.out.println("我的电影");
		return "my-movies";
	}

	/**
	 * 去登陆
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin() {
		System.out.println("登陆");
		return "login";
	}

	/**
	 * 去注册
	 * @return
	 */
	@RequestMapping("/toregister")
	public String toRegister() {
		System.out.println("注册");
		return "register";
	}

	/**
	 * 管理员界面
	 * @return
	 */
	@RequestMapping("/admin")
	public String admin() {
		System.out.println("管理员界面");
		return "admin";
	}

	/**
	 * 电影管理
	 * @return
	 */
	@RequestMapping("/admin-movies")
	public String movies() {
		System.out.println("电影管理");
		return "admin-movies";
	}

	/**
	 * 评论管理
	 * @return
	 */
	@RequestMapping("/admin-remark")
	public String remark() {
		System.out.println("评论管理");
		return "admin-remark";
	}

	/**
	 * 登陆拦截返回
	 * @return
	 */
	@RequestMapping("/loginError")
	@ResponseBody
	public String error() {
		return "error！please login";
	}

	@RequestMapping("header")
	public String header() {
		return "header";
	}
}
