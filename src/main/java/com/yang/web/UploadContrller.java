package com.yang.web;

import com.yang.entity.User;
import com.yang.util.ImgUtil;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static com.yang.config.ProjectConstant.*;

/**
 * @author Yyang
 * @create 2018/1/5.
 * 文件上传
 */
@RestController
@RequestMapping("/upload")
public class UploadContrller {

	@Resource
	private UserController userController;

	/**
	 * 用户更换头像
	 *
	 * @param img
	 * @param session
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Result uploadUser(@RequestParam(value = "img") MultipartFile img, HttpSession session) {
		System.out.println("上传图片...");

		try {
			int id = (int) session.getAttribute("id");

			if (id == 0) {
				return ResultGenerator.genFailResult("图片更新失败");
			}
			User user = new User();
			user.setUserid(id);

			user.setImg(upload(img, USER_UPLOADED_FOLDER).getData().toString());
			//更新用户头像
			return userController.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultGenerator.genFailResult("图片更新失败");
	}

	/**
	 * 上传电影海报
	 *
	 * @param img 图片文件
	 * @return
	 */
	@RequestMapping(value = "/movie", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Result uploadMovie(@RequestParam(value = "img") MultipartFile img) {
		System.out.println("上传图片...电影海报");

		return upload(img, MOVIE_UPLOADED_FOLDER);
	}

	/**
	 * 上传演员头像
	 *
	 * @param img
	 * @return
	 */
	@RequestMapping(value = "/actor", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Result uploadActor(@RequestParam(value = "img") MultipartFile img) {
		System.out.println("上传图片...演员海报");

		return upload(img,ACTOR_UPLOADED_FOLDER);
	}

	/**
	 * 处理图片
	 * @param img
	 * @param folder
	 * @return
	 */
	private Result upload(MultipartFile img,String folder) {
		if (img != null) {
			String imgPath = "";

			try {
				imgPath = ImgUtil.cloudImg(img, folder);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ResultGenerator.genSuccessResult(imgPath);
		}
		return ResultGenerator.genFailResult("图片文件不存在");
	}
}
