package com.yang.service;

import com.yang.entity.Remark;

import java.util.List;

/**
* @author Yyang
* @create2018/01/05
*/
public interface RemarkService{

	/**
	 * 插入评论
	 * @param remarkContent
	 * @param score
	 * @param movieId
	 * @param userId
	 */
	void addRemark(String remarkContent,float score,int movieId,int userId);

	/**
	 * 查询电影的评论
	 * @param movieId
	 * @return
	 */
	List<Remark> remarkByMovieId(int movieId);

	/**
	 * 查询用户评论
	 * @param userId
	 * @return
	 */
	List<Remark> remarkByUserId(int userId);

	/**
	 * 全部评论
	 * @return
	 */
	List<Remark> remarkAll();
}
