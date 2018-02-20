package com.yang.util;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.yang.config.ProjectConstant.*;

/**
 * @author Yyang
 * @create 2017/11/30.
 * 用于保存图片的工具类
 */
public class ImgUtil {

	/**
	 * 上传图片
	 * @param file 图片文件
	 * @param uploadFolder 图片保存路径 用户 电影 演员 海报
	 * @return
	 * @throws Exception
	 */
	public static String uploadImg(MultipartFile file, String uploadFolder)throws Exception {
		String fileName;
		//如果图片是用户头像
		if (uploadFolder==USER_UPLOADED_FOLDER){
			//按时间随机命名
			fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date())+".jpg";
		}else {
			fileName = file.getOriginalFilename();
		}
		//将图片保存到磁盘
		try {
			Path path = Paths.get(BASE_DISK_FOLDER + uploadFolder + fileName);
			Files.write(path, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

	/**
	 * 图片云存储
	 * @param file
	 * @param uploadFolder
	 * @return imgUrl 需要返回的图片链接
	 * @throws Exception
	 */
	public static String cloudImg(MultipartFile file,String uploadFolder)throws Exception{

		//配置云存储
		Configuration cfg = new Configuration(Zone.zone1());
		UploadManager uploadManager = new UploadManager(cfg);
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		String upToken = auth.uploadToken(BUCKET);

		String fileName;
		//如果图片是用户头像
		if (uploadFolder==USER_UPLOADED_FOLDER){
			//按时间随机命名
			fileName=new SimpleDateFormat("yyyyMMddHHmmssSSS") .format(new Date())+".jpg";
		}else {
			fileName = file.getOriginalFilename();
		}

		String imgUrl = "";

		try {
			//上传图片目录uploadFolder + 图片原始名file.getOriginalFilename()
			Response response = uploadManager.put(file.getBytes(),
					uploadFolder + fileName,
					upToken);
			DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
			imgUrl = putRet.key;
			System.out.println(imgUrl);
		} catch (Exception e) {
			System.out.println(e);
		}
		return imgUrl;
	}

}
