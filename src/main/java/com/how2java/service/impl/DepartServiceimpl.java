package com.how2java.service.impl;

/**
 * Created by Administrator on 2018/9/8.
 */

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageHelper;
import com.how2java.domain.Depart;
import com.how2java.mapper.DepartMapper;
import com.how2java.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("departService")

public class DepartServiceimpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;

    @Override
    public PageInfo<Depart> getDepartList(Integer currentPage, Integer pageSize){
        PageHelper.startPage(currentPage, pageSize);
        List<Depart> docs = departMapper.selectDepartList();
        PageInfo<Depart> pageInfo = new PageInfo<>(docs);
        return pageInfo;
    }

    @Override
    public String insert(Depart depart){
        Depart depart1=departMapper.checkDepartName(depart.getDepartname());
        if(depart1 == null) {
            String departname = depart.getDepartname();
            String description = depart.getDescription();
            int personCound = depart.getPersoncount();
            Depart pojo = new Depart();
            pojo.setDepartname(departname);
            pojo.setDescription(description);
            pojo.setPersoncount(personCound);
            departMapper.insert(pojo);
            return "新增成功";
        }else{
            return "部门名已存在";
        }
    }

    @Override
    public int remove(Integer id){
        return departMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Depart modified(Integer id){
        Depart depart = departMapper.selectByPrimaryKey(id);
        return depart;
    }

    @Override
    public Depart displayDepartUser(Integer id){
        Depart depart = departMapper.displayDepartUser(id);
        return depart;
    }

    @Override
    public int update(Depart record){
        int updated = departMapper.updateByPrimaryKey(record);
        return updated;
    }
}
