package com.yang.service.impl;

import com.yang.dao.RemarkMapper;
import com.yang.dao.UserMapper;
import com.yang.entity.Remark;
import com.yang.service.RemarkService;
import com.yang.util.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* @author Yyang
* @create2018/01/05
*/
@Service
@Transactional
public class RemarkServiceImpl implements RemarkService {
    @Resource
    private RemarkMapper remarkMapper;

    @Override
    public void addRemark(String remarkContent, int movieId, int userId) {
        if (remarkContent == null) {
            throw new ServiceException("评论不能为空");
        }
        Remark remark = new Remark();
        remark.setContent(remarkContent);
        remarkMapper.addRemark(remark);

        if (null==remark||remark.getRemarkid()==0) {
            throw new ServiceException("评论失败");
        }
        if (!remarkMapper.addUmr(remark.getRemarkid(), movieId, userId)) {
            throw new ServiceException("评论失败");
        }
        System.out.println("评论成功");
    }

    @Override
    public List<Remark> remarkByMovieId(int movieId) {
        List<Remark> remarks = remarkMapper.selectRemarkByMovie(movieId);

        return remarks;
    }

    @Override
    public List<Remark> remarkByUserId(int userId) {
        List<Remark> remarks = remarkMapper.selectRemarkByUser(userId);

        return remarks;
    }

    @Override
    public List<Remark> remarkAll() {
        return remarkMapper.selectAll();
    }

}
