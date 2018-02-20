package com.yang.service;

import com.yang.entity.Movie;

import java.util.List;

/**
* @author Yyang
* @create2018/01/05
*/
public interface MovieService extends Service<Movie> {


	/**
	 * 通过电影名查询
	 * @param name
	 * @return
	 */
	List<Movie> selectByName(String name);

}
