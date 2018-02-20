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
	@Resource
	private MovieService movieService;
	@Resource
	private ActorService actorService;
	@Resource
	private RemarkService remarkService;
	@Test
	public void login() {
		Condition condition = new Condition(User.class);

		List<User> user = userService.findByCondition(condition);
		//User user = userService.login("13512341234", "13512341234");
		//System.out.println(user.get(0).getNickName());
	}

	@Test
	public void test() {
		Condition condition = new Condition(Movie.class);
		condition.createCriteria().andBetween("time", "2017-11-01", "2017-12-01");
		List<Movie> list = movieService.findByCondition(condition);
		System.out.println(list.size());
	}

	@Test
	public void condition() {
		Condition condition = new Condition(User.class);
		condition.createCriteria()
				.andEqualTo("number", "13512341234")
				.andEqualTo("password", "13512341234");
		List<User> list = userService.findByCondition(condition);
		System.out.println(list.get(0).toString());
	}

	@Test
	public void dateTest() {
	}

	@Test
	public void RemarkTest() {
		Remark remark = new Remark();
		remark.setContent("测试评论");
		remarkService.addRemark("测试评论",58,1);
	}
	@Test
	public void selectRemark() {

		List<Remark> remarks = remarkService.remarkByMovieId(59);
		System.out.println(remarks.get(0).toString());

	}
}
