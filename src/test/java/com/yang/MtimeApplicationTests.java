package com.yang;

import com.github.pagehelper.PageInfo;
import com.yang.entity.Movie;
import com.yang.entity.Remark;
import com.yang.service.MovieSerivce;
import com.yang.service.RemarkService;
import com.yang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MtimeApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	MovieSerivce movieSerivce;
	@Autowired
	RemarkService remarkService;

	@Test
	public void selectMovie() {
		List<Movie> list = movieSerivce.seleteRecentMovies();
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getTitleCn());
		}
	}

	@Test
	public void selectMovieById() {
//		List<Movie> list = movieSerivce.selectMovieById("25");
//		if (list.size() > 0) {
//			System.out.println(list.get(0).getTitleCn());
//		}
	}

	@Test
	public void selectAll() {
		PageInfo<Movie> movie=movieSerivce.selectAllMovie(2, 4);
		System.out.println("总计"+movie.getTotal());
	}

	@Test
	public void selectName() {
		PageInfo<Movie> movie = movieSerivce.seletcMoviesByName("夺金");
		System.out.println(movie.getList().get(0).getTitleCn());
	}

	@Test
	public void insterRemark() {
		List<Remark> list = remarkService.getMovieRemark(7);

	}

	@Test
	public void deleteRemark() {
		if (remarkService.deleteRemark(19)) {
			System.out.println("success");
		}
	}

	@Test
	public void getUserRemark(){
		List<Remark> remarks = remarkService.getUserRemark(7);
		if (remarks.get(0).getTitleCn() != null) {
			System.out.println(remarks.get(0).getTitleCn());
		}
	}
}
