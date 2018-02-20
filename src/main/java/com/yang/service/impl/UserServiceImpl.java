package com.yang.service.impl;

import com.yang.dao.AdminMapper;
import com.yang.dao.UserMapper;
import com.yang.entity.User;
import com.yang.service.UserService;
import com.yang.util.ServiceException;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
* @author Yyang
* @create2018/01/04
*/
@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
