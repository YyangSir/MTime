package com.yang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.regexp.internal.RE;
import com.yang.entity.BoxOffice;
import com.yang.entity.Movie;
import com.yang.entity.Remark;
import com.yang.entity.User;
import com.yang.service.ActorService;
import com.yang.service.MovieService;
import com.yang.service.RemarkService;
import com.yang.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MtimeApplicationTests extends Tester{
	@Resource
	private UserService userService;
	@Autowired
	private RemarkService remarkService;
	@Test
	public void login() {
		Condition condition = new Condition(User.class);

		List<User> user = userService.findByCondition(condition);
		//User user = userService.login("13512341234", "13512341234");
		//System.out.println(user.get(0).getNickName());
	}

	@Test
	public void rdeisTest() {
		remarkService.addRemark("测试评分",2,59,1);
	}

	@Test
	public void box() {
		String appid = "60b7f6e83bd90998922a6a4835119273";
		String httpUrl = "http://api.shenjian.io/";
		String httpArg = "appid=" + appid;

		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();

		httpUrl = httpUrl + "?" + httpArg;

		try {

			URL url = new URL(httpUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.connect();

			InputStream is = connection.getInputStream();

			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			String strRead = null;

			while ((strRead = reader.readLine()) != null) {

				sbf.append(strRead);

				sbf.append("\r\n");

			}
			reader.close();
			result = sbf.toString();
			JSONObject jsonObject = JSON.parseObject(result);
			System.out.println(jsonObject);

			List<BoxOffice> boxOfficeList = new ArrayList<BoxOffice>();
			if (jsonObject.getIntValue("error_code") == 0) {
				JSONArray jsonArray=jsonObject.getJSONArray("data");
				int len = jsonArray.size();

				for (int i = 0; i < len; i++) {
					BoxOffice boxOffice = new BoxOffice();
					System.out.println(jsonArray.get(i).toString());
					System.out.println(JSON.parseObject(jsonArray.get(i).toString()).getString("MovieName"));

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
