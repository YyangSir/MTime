package com.yang.contrller;

import com.github.pagehelper.PageInfo;
import com.yang.entity.Movie;
import com.yang.service.MovieSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Yyang
 * @create 2017/12/3.
 */
@RestController
public class MovieContrller {
	private static int PAGE_INDEX = 1;
	private static int PAGE_SIZE = 12;

	@Autowired
	MovieSerivce movieSerivce;

	/**
	 * 获取近期电影
	 * @return
	 */
	@RequestMapping(value = "/movie/recent",method = RequestMethod.GET)
	public List<Movie> recentMovies(){

		List<Movie> movies = movieSerivce.seleteRecentMovies();

		return movies;
	}

	/**
	 * 根据id查询电影详细信息
	 * @param movieId
	 * @return
	 */
	@RequestMapping(value = "/movie/info/{id}", method = RequestMethod.GET)
	public List<Movie> getMovieInfo(@PathVariable("id") int movieId, HttpSession session) {
		System.out.println("查询电影详细信息"+movieId);
		session.setAttribute("movieId", movieId);
		List<Movie> movie = movieSerivce.selectMovieById(movieId);
		return movie;
	}

	/**
	 * 查询所有电影信息
	 * @param pageIndex 当前页
	 * @param pageSize 页面电影数量 默认 12
	 * @return
	 */
	@RequestMapping(value = "/movie/all", method = RequestMethod.POST)
	public PageInfo<Movie> getAllMovies(@PathParam("pageIndex") int pageIndex,
										@PathParam("pageSize") int pageSize) {

		PageInfo<Movie> moviePageInfo = movieSerivce.selectAllMovie(pageIndex, pageSize);
		return moviePageInfo;
	}

	/**
	 * 按名字查询电影信息
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/movie/name_{titleCn}", method = RequestMethod.GET)
	public PageInfo<Movie> selectMovieByName(@PathVariable("titleCn") String name) {
		if (name == null || name.isEmpty()) {
			return getAllMovies(PAGE_INDEX, PAGE_SIZE);
		}

		PageInfo<Movie> moviePageInfo = movieSerivce.seletcMoviesByName(name);
		return moviePageInfo;
	}

}
