package com.yang;

import com.sun.org.apache.regexp.internal.RE;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
