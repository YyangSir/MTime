package com.yang.service.impl;

import com.yang.dao.MovieMapper;
import com.yang.entity.Movie;
import com.yang.service.MovieService;
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
public class MovieServiceImpl extends AbstractService<Movie> implements MovieService {
    @Resource
    private MovieMapper movieMapper;

    @Override
    public List<Movie> selectByName(String name) {
        return movieMapper.selectByName(name);
    }

}
