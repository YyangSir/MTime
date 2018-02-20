package com.yang.service.impl;

import com.yang.dao.AdminMapper;
import com.yang.entity.Admin;
import com.yang.service.AdminService;
import com.yang.util.ServiceException;
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
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

}
