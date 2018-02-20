package com.yang.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 13512
 * @create 2018/2/3.
 */
@Controller
public class AdminRouteController {

	/**
	 * 管理员登陆
	 *
	 * @return
	 */
	@RequestMapping("/admin-login")
	public String admin_login() {
		return "admin-login";
	}

	/**
	 * 上传电影信息
	 *
	 * @return
	 */
	@RequestMapping("/admin-index")
	public String admin() {
		return "admin-index";
	}


	/**
	 * 上传演员信息
	 *
	 * @return
	 */
	@RequestMapping("/admin-actor")
	public String actor() {
		return "admin-actor";
	}


/*******************↑上传信息***********************↓管理信息********************************************************/

	/**
	 * 电影管理
	 *
	 * @return
	 */
	@RequestMapping("/admin-movies")
	public String movies() {
		return "admin-movies";
	}

	/**
	 * 评论管理
	 *
	 * @return
	 */
	@RequestMapping("/admin-remark")
	public String remark() {
		return "admin-remark";
	}

	/**
	 * 演员列表
	 *
	 * @return
	 */
	@RequestMapping("/admin-actors")
	public String actors() {
		return "admin-actors";
	}

	/**
	 * 用户列表
	 *
	 * @return
	 */
	@RequestMapping("/admin-users")
	public String userList() {
		return "admin-users";
	}


	@RequestMapping("admin-error")
	public String error() {
		return "admin-error";
	}
}
