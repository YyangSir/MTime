package com.yang.service.impl;

import com.yang.dao.ActorMapper;
import com.yang.dao.MovieMapper;
import com.yang.entity.Actor;
import com.yang.service.ActorService;
import com.yang.util.ServiceException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
* @author Yyang
* @create2018/01/24
*/
@Service
@Transactional
public class ActorServiceImpl extends AbstractService<Actor> implements ActorService {
    @Resource
    private ActorMapper actorMapper;
    @Resource
    private MovieMapper movieMapper;
    //todo 查询电影的演员

    @Override
    public List<Actor> selectByName(String name) {
        List<Actor> actors = actorMapper.selectByName(name);
        if (null == actors || actors.size() == 0) {
            throw new ServiceException("没有此演员信息");
        }
        return actors;
    }
}
