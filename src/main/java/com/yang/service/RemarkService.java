package com.yang.service;


import com.github.pagehelper.PageInfo;
import com.yang.entity.Remark;

import java.util.List;

/**
 * @author Yyang
 * @create 2017/12/4.
 */
public interface RemarkService {
	/**
	 * 插入一条评论
	 * @param content 评论内容
	 * @param userId 用户id
	 * @param movieId 电影id
	 * @return
	 */
	boolean insertRemark(String content,int userId,int movieId);

	/**
	 * 返回所有评论
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	PageInfo<Remark> getAllRemark(int pageNo, int pageSize);

	/**
	 * 返回电影的评论列表
	 * @param movieId
	 * @return
	 */
	List<Remark> getMovieRemark(int movieId);

	/**
	 * 删除一条评论
	 * @param remarkId
	 * @return
	 */
	boolean deleteRemark(int remarkId);

	/**
	 * 获取用户评论
	 * @param userId
	 * @return
	 */
	List<Remark> getUserRemark(int userId);
}
