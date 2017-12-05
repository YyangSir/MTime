package com.yang.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Yyang
 * @create 2017/11/30.
 * 用于保存图片的工具类
 */
public class ImgUtil {
	private static String UPLOADED_FOLDER = "E:/Java_project/img/movie/";

	public static String saveImg(MultipartFile file)throws Exception {
		if (file != null) {
			String fileName = file.getOriginalFilename();
			try {
				Path path = Paths.get(UPLOADED_FOLDER + fileName);
				Files.write(path, file.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return fileName;
		}
		return null;
	}
}
