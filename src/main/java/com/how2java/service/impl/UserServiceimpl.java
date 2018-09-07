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

    @Override
    public String insert(String loginname, String password) {
        User user=userMapper.getUserByLoginName(loginname);
        if(user==null){
            User userpojo=new User();
            userpojo.setLoginname(loginname);
            userpojo.setPassword(password);
            userpojo.setRole(1);
            userMapper.insert(userpojo);
            return "新增成功";
        }else{
            return "账号已经存在";
        }
    }

    @Override
    public int remove(Integer id){
        userMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public User modified(Integer id){
        User user=userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int update(User record){
        int updated = userMapper.updateByPrimaryKey(record);
        return updated;
    }
}
