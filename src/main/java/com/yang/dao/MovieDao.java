package com.yang.dao;

import com.yang.entity.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/10/31.
 */
public interface MovieDao {

	/**
	 * 插入一部电影
	 *
	 * @param movie
	 * @return
	 */
	@Insert("insert into movies(titleCn,titleEn,director,actors,story,type,moviesTime,img)" +
			"values(#{titleCn},#{titleEn},#{director},#{actors},#{story},#{type},#{moviesTime},#{img})")
	boolean insertMovie(Movie movie);

	/**
	 * 查询最近的电影列表
	 * @param n
	 * @return 返回n条记录
	 */
	@Select("select movieId,img,titleCn from movies " +
			"order by movieId desc limit #{n}")
	List<Movie> recentMovies(int n);

	/**
	 * 按id查询电影
	 * @param id
	 * @return
	 */
	@Select("select * from movies where movieId=#{id}")
	List<Movie> selectMovieById(int id);

	/**
	 * 查询所有的电影
	 *
	 * @return
	 */
	@Select("select movieId,img,titleCn,moviesTime from movies " +
			"order by movieId desc")
	List<Movie> allMovies();

	/**
	 * 模糊查询电影名
	 * @param name
	 * @return
	 */
	@Select("select movieId,img,titleCn,moviesTime from movies" +
			" where titleCn like concat(concat('%',#{name}),'%')")
	List<Movie> nameMovies(String name);

	/**
	 * 删除一部电影
	 * @param id 评论id
	 * @return
	 */
	@Delete("delete from movies where movieId=#{id}")
	boolean deleteRemark(@Param("id") int id);


}
