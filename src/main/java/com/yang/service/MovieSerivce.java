package com.yang.service;

import com.github.pagehelper.PageInfo;
import com.yang.entity.Movie;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/11/8.
 */
public interface MovieSerivce{
	/**
	 * 上传电影
	 * @param movie
	 * @return
	 */
	boolean saveMovie(Movie movie);

	/**
	 * 查询最近电影
	 * @return
	 */
	List<Movie> seleteRecentMovies();

	/**
	 * 按id查询电影
	 * @param id
	 * @return
	 */
	List<Movie> selectMovieById(int id);

	/**
	 * 分页查询所有电影
	 * @param pageNo 页数
	 * @param pageSize 单页大小
	 * @return
	 */
	PageInfo<Movie> selectAllMovie(int pageNo, int pageSize);

	/**
	 * 按名称查询电影
	 * @param name
	 * @return
	 */
	PageInfo<Movie> seletcMoviesByName(String name);

	/**
	 * 删除电影
	 * @param movieId
	 * @return
	 */
	boolean deleteMovie(int movieId);


}
