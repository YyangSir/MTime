package com.yang.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Yyang
 * @create 2017/11/30.
 * 用于保存图片的工具类
 */
public class ImgUtil {
	private static String MOVIE_UPLOADED_FOLDER = "E:/Java_project/img/movie/";
	private static String USER_UPLOADED_FOLDER = "E:/Java_project/img/user/";

	/**
	 * 上传电影图片
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String saveImg(MultipartFile file)throws Exception {
		if (file != null) {
			String fileName = file.getOriginalFilename();
			try {
				Path path = Paths.get(MOVIE_UPLOADED_FOLDER + fileName);
				Files.write(path, file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}
		return null;
	}

	/**
	 * 上传用户图片
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String savrPhoto(MultipartFile file) throws Exception{
		if (file != null) {
			String fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date())+".jpg";
			System.out.println(fileName);
			try {
				Path path = Paths.get(USER_UPLOADED_FOLDER + fileName);
				Files.write(path, file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}
		return null;
	}
}
