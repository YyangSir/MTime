package com.yang.dao;

import com.yang.entity.Remark;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * @author Yyang
 * @create 2017/11/5.
 */
public interface RemarkDao {
	/**
	 * 插入一个评论
	 *
	 * @param content
	 * @param date
	 * @param userId
	 * @param movieId
	 * @return
	 */
	@Insert("insert into remarks(remarkContent,remarkTime,userId,movieId) " +
			"values(#{remarkContent},#{remarkTime},#{userId},#{movieId})")
	boolean insertRemark(@Param("remarkContent") String content, @Param("remarkTime") Date date,
						 @Param("userId") int userId, @Param("movieId") int movieId);

	/**
	 * 查询电影的评论
	 *
	 * @param movieId
	 * @return
	 */
	@Select("select r.* ,u.userName,u.userPhoto from remarks r,users u where r.userId=u.userId and movieId=#{movieId} " +
			"order by remarkId desc")
	List<Remark> getMovieRemark(@Param("movieId") int movieId);

	/**
	 * 查询所有评论
	 *
	 * @return
	 */
	@Select("select r.*,u.userName from remarks r,users u where r.userId=u.userId order by remarkId desc")
	List<Remark> getAllRemark();

	/**
	 * 删除一条评论
	 *
	 * @param id 评论id
	 * @return
	 */
	@Delete("delete from remarks where remarkId=#{id}")
	boolean deleteRemark(@Param("id") int id);

	/**
	 * 查询用户的评论
	 * @param userId
	 * @return
	 */
	@Select("select r.*,m.titleCn,m.img from remarks r,movies m where r.movieId=m.movieId and r.userId=#{id} order by remarkId desc")
	List<Remark> getUserRemark(@Param("id") int userId);
}
