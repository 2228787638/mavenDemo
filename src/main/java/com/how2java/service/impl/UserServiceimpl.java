package com.how2java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.domain.User;
import com.how2java.mapper.UserMapper;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo<User> getUserList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<User> docs = userMapper.selectUserList();
        PageInfo<User> pageInfo = new PageInfo<>(docs);
        return pageInfo;
    }
}
