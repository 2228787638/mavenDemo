package com.how2java.service;

/**
 * Created by Administrator on 2018/9/19.
 */

import com.github.pagehelper.PageInfo;
import com.how2java.domain.Fileupload;

public class FileService {
    /**
     * 文件列表（分页）
     * @param currentPage 当前页码
     * @param pageSize 每页的数据大小
     * @return 文件分页对象
     */

    PageInfo<Fileupload> getFileList(int currentPage, int pageSize);

    String insert(int userid);


}
