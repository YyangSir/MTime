package com.yang.service.impl;

import com.yang.dao.MovieMapper;
import com.yang.dao.RemarkMapper;
import com.yang.entity.Movie;
import com.yang.entity.Remark;
import com.yang.service.MovieService;
import com.yang.service.RemarkService;
import com.yang.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
* @author Yyang
* @create2018/01/05
*/
@Service
@Transactional
public class RemarkServiceImpl implements RemarkService {
    @Autowired
    private RemarkMapper remarkMapper;
    @Autowired
    private MovieService movieService;

    @Override
    public void addRemark(String remarkContent,float score, int movieId, int userId) {
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
        //查询评分
        float rating = movieService.findById(movieId).getRating();
        if (score != rating) {
            int count = remarkMapper.count(movieId);
            Movie movie = new Movie();
            movie.setMovieid(movieId);
            //判断评分高低
            if (score > rating) {
                score -= rating;
                score /= count;
                score += rating;
                movie.setRating(score);
            } else if (score < rating) {
                score = rating - score;
                score /= count;
                score = rating - score;
                movie.setRating(score);
            }
            movieService.update(movie);
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
