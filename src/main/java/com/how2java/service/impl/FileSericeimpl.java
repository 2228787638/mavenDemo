package com.how2java.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.domain.Fileupload;
import com.how2java.mapper.FileuploadMapper;
import com.how2java.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Administrator on 2018/9/19.
 */

@Service("FileService")

public class FileSericeimpl implements FileService{

    @Autowired
    private FileuploadMapper fileuploadMapper;

    @Override
    public PageInfo<Fileupload> getFileList(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Fileupload> docs = fileuploadMapper.selectFileList();
        PageInfo<Fileupload> pageInfo = new PageInfo<>(docs);
        return pageInfo;
    }

    @Override
    public String insert(int userid) {
        Fileupload file = FileuploadMapper.getFileUploadName(userid);
        if(fileuploadMapper==null){
            FileuploadMapper filepojo=new FileuploadMapper();
            filepojo.setUserid(userid);
            fileuploadMapper.insert(filepojo);
            return "文件上传成功";
        }else{
            return "文件已经存在";
        }
    }


}
