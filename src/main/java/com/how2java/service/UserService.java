package com.how2java.service;

import com.github.pagehelper.PageInfo;
import com.how2java.domain.User;

public interface UserService {
    /**
     * 用户列表（分页）
     * @param currentPage 当前页码
     * @param pageSize 每页的数据大小
     * @return 用户分页对象
     */
    PageInfo<User> getUserList(int currentPage, int pageSize);

    String insert(String loginname, String password);

    int remove(Integer id);

    User modified(Integer id);

    int update(User record);
}

