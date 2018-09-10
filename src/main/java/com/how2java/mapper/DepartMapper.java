package com.how2java.mapper;

import com.how2java.domain.Depart;

public interface DepartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);
}