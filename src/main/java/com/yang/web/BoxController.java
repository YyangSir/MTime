package com.yang.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yang.entity.BoxOffice;
import com.yang.util.Result;
import com.yang.util.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 13512
 * @create 2018/3/30.
 */
@RestController
@RequestMapping("box")
public class BoxController {
	private final static String ERROE_CODE = "error_code";

	@GetMapping
	public Result boxOffice() {
		List<BoxOffice> boxOfficeList = new ArrayList<BoxOffice>();
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

			if (jsonObject.getIntValue(ERROE_CODE) == 0) {
				JSONArray jsonArray=jsonObject.getJSONArray("data");
				int len = jsonArray.size();

				for (int i = 0; i < len; i++) {
					BoxOffice boxOffice = new BoxOffice();
					boxOffice.setIrank(JSON.parseObject(jsonArray.get(i).toString()).getString("Irank"));
					boxOffice.setMovieName(JSON.parseObject(jsonArray.get(i).toString()).getString("MovieName"));
					boxOffice.setBoxOffice(JSON.parseObject(jsonArray.get(i).toString()).getString("BoxOffice"));
					boxOffice.setSumBoxOffice(JSON.parseObject(jsonArray.get(i).toString()).getString("sumBoxOffice"));
					boxOffice.setMovieDay(JSON.parseObject(jsonArray.get(i).toString()).getString("movieDay"));
					boxOffice.setBoxPer(JSON.parseObject(jsonArray.get(i).toString()).getString("boxPer"));
					boxOffice.setTime(JSON.parseObject(jsonArray.get(i).toString()).getString("time"));
					boxOfficeList.add(boxOffice);
				}

				return ResultGenerator.genSuccessResult(boxOfficeList);
			}else {
				return ResultGenerator.genFailResult(jsonObject.getString("reason"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResultGenerator.genFailResult("获取失败，请检查网络");
	}
}
