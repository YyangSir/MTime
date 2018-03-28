package com.yang.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yyang
 * @create 2017/11/9.
 * 跳转控制
 */
@Controller
public class RouteController {

	/**
	 * 主页
	 * @return
	 */
	@RequestMapping( value = {"/","/index","/home"})
	public String index() {
		return"index";
	}

	/**
	 * 去电影列表
	 * @return
	 */
	@RequestMapping("/tolist")
	public String toList() {
		return "movie-list";
	}

	/**
	 * 经典电影
	 */
	@RequestMapping("/classic-list")
	public String toclassic() {
		return "classic-list";
	}

	/**
	 * 去演员列表
	 * @return
	 */
	@RequestMapping("/actor-list")
	public String toactors() {
		return "actor-list";
	}

	/**
	 * 查看演员信息
	 * @return
	 */
	@RequestMapping("/actor-info")
	public String toActorInfo() {
		return "actor-info";
	}
	/**
	 * 去评论页
	 * @return
	 */
	@RequestMapping("/toremark")
	public String toRemark() {
		return "remark";
	}

	/**
	 * 去我的电影
	 * @return
	 */
	@RequestMapping("/tomy")
	public String toMy() {
		return "my-movies";
	}

	/**
	 * 去登陆
	 * @return
	 */
	@RequestMapping("/tologin")
	public String toLogin() {
		return "login";
	}

	/**
	 * 去注册
	 * @return
	 */
	@RequestMapping("/toregister")
	public String toRegister() {
		return "register";
	}

	/**
	 * 登陆拦截返回
	 * @return
	 */
	@RequestMapping("/userError")
	public String error() {
		return "404";
	}

}
