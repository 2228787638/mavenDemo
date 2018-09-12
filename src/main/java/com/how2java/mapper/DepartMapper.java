package com.how2java.mapper;

import com.how2java.domain.Depart;

import java.util.List;

public interface DepartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);

    Depart checkDepartName(String departName);

    List<Depart> selectDepartList();

    Depart displayDepartUser(Integer id);
}