package com.how2java.service;

import com.github.pagehelper.PageInfo;
import com.how2java.domain.Depart;

/**
 * Created by Administrator on 2018/9/8.
 */
public interface DepartService {
    /**
     * 部门列表(分页)
     * @param currentPage 当前页码
     * @param pageSize 每页的数据大小
     * @return 用户分页对象
     */
    PageInfo<Depart> getDepartList(int currentPage, int pageSize);

    String insert(String department, String description);

    int remove(Integer id);

    Depart modified(Integer id);

    int update(Depart record);
}
