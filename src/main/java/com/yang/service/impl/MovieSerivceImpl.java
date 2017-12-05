package com.yang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.MovieDao;
import com.yang.entity.Movie;
import com.yang.service.MovieSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/11/8.
 */
@Service
public class MovieSerivceImpl implements MovieSerivce {
	//电影数量
	private static int MOVIE_NUMBER = 4;

	@Autowired
	MovieDao movieDao;

	@Override
	public boolean saveMovie(Movie movie) {
		return movieDao.insertMovie(movie);
	}

	@Override
	public List<Movie> seleteRecentMovies() {
		List<Movie> movies = movieDao.recentMovies(MOVIE_NUMBER);

		return removeYear(movies);
	}

	@Override
	public List<Movie> selectMovieById(int id) {
		if (id == 0 ) {
			return null;
		}
		List<Movie> movies = movieDao.selectMovieById(id);
		if (movies.size() == 0) {
			return null;
		}

		String Y=movies.get(0).getMoviesTime().replaceFirst("-", "年");
		String M = Y.replaceFirst("-", "月");
		String D = M + "日";
		movies.get(0).setMoviesTime(D);
		return movies;
	}

	@Override
	public PageInfo<Movie> selectAllMovie(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Movie> list = movieDao.allMovies();
		if (list.size() == 0) {
			return null;
		}

		PageInfo<Movie> pageInfo = new PageInfo<>(removeYear(list));
		return pageInfo;
	}

	@Override
	public PageInfo<Movie> seletcMoviesByName(String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}
		PageHelper.startPage(1,3);
		List<Movie> list = movieDao.nameMovies(name);
		if (list.size() == 0) {
			return null;
		}

		PageInfo<Movie> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public boolean deleteMovie(int movieId) {
		return movieDao.deleteRemark(movieId);
	}

	/**
	 * 去掉titleCn结尾年份
	 * @param movies
	 * @return
	 */
	private List<Movie> removeYear(List<Movie> movies) {
		int n = movies.size();
		for (int i=0;i<n;i++) {
			int m = movies.get(i).getTitleCn().length();
			String name = movies.get(i).getTitleCn().substring(0, m - 6);
			movies.get(i).setTitleCn(name);
		}
		return movies;
	}
}
