package com.yang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.RemarkDao;
import com.yang.entity.Remark;
import com.yang.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Yyang
 * @create 2017/12/4.
 */
@Service
public class RemarkServiceImpl implements RemarkService {
	@Autowired
	RemarkDao remarkDao;

	@Override
	public boolean insertRemark(String content, int userId, int movieId) {
		return remarkDao.insertRemark(content,new Date(), userId, movieId);
	}

	@Override
	public List<Remark> getMovieRemark(int movieId) {
		List<Remark> remarkList = remarkDao.getMovieRemark(movieId);
		//修改data格式
		time(remarkList);
		return remarkList;
	}

	@Override
	public boolean deleteRemark(int remarkId) {
		return remarkDao.deleteRemark(remarkId);
	}

	@Override
	public PageInfo<Remark> getAllRemark(int pageNo, int pageSize) {
		//分页
		PageHelper.startPage(pageNo, pageSize);
		List<Remark> remarks=remarkDao.getAllRemark();

		time(remarks);
		PageInfo<Remark> remarkPageInfo = new PageInfo<>(remarks);
		return remarkPageInfo;
	}

	/**
	 * 修改时间格式
	 * @param list
	 * @return
	 */
	private void time(List<Remark> list) {
		int n = list.size();
		for(int i=0;i<n;i++) {
			list.get(i).setRemarkData(list.get(i).getRemarkTime().toString());
		}
	}

}
