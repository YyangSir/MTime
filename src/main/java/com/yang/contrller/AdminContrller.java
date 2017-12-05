package com.yang.contrller;

import com.yang.entity.Movie;
import com.yang.service.MovieSerivce;
import com.yang.util.ImgUtil;
import com.yang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Yyang
 * @create 2017/11/9.
 */
@RestController
public class AdminContrller {

	@Autowired
	MovieSerivce movieSerivce;

	String movieImg;

	/**
	 * 上传图片
	 *
	 * @param img 图片文件
	 * @return
	 */
	@RequestMapping(value = "/movie/uploadImg", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map uploadImg(@RequestParam(value = "img") MultipartFile img) {
		System.out.println("上传图片...");

		if (img == null) {
			return Message.message(false);
		}

		//保存图片
		try {
			movieImg = ImgUtil.saveImg(img);
			if (movieImg != null) {
				return Message.message(true, "movieImg", movieImg);
			}
		} catch (Exception e) {

		}
		return Message.message(false);
	}

	/**
	 * 上传电影信息
	 *
	 * @param movie
	 */
	@RequestMapping(value = "/movie/upload", method = RequestMethod.POST)
	public Map uploadMovie(Movie movie) {
		System.out.println("上传电影...");
		movie.setImg(movieImg);
		movieImg = "";
		System.out.println(movie.toString());

		movieSerivce.saveMovie(movie);

		return Message.message(true);
	}

	/**
	 * 删除一部电影
	 * @param movieId
	 * @return
	 */
	@RequestMapping(value = "/movie/delete_{id}", method = RequestMethod.DELETE)
	public Map deleteMovie(@PathVariable("id") int movieId) {
		if (movieSerivce.deleteMovie(movieId)) {
			return Message.message(true);
		}
		return Message.message(false);
	}

}
