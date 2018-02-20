package com.yang.dao;

import com.yang.entity.Movie;
import com.yang.mapper.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yyang
 * @create 2018/01/06
 */
public interface MovieMapper extends Mapper<Movie> {

	/**
	 * 按名称查询
	 *
	 * @param name 电影中文或英文名 参与演员名 导演名
	 * @return
	 */
	@Select("select movieId,img,titleCn,time from movie " +
			"where titleCn like concat(concat('%',#{name}),'%') " +
			"or titleEn like concat(concat('%',#{name}),'%') " +
			"or director like concat(concat('%',#{name}),'%') " +
			"or actors like concat(concat('%',#{name}),'%') " +
			"or type like concat(concat('%',#{name}),'%')")
	List<Movie> selectByName(String name);

}