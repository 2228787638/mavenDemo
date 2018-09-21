package com.how2java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Created by Administrator on 2018/9/17.
 */

@RequestMapping(value = "/upload", method= RequestMethod.POST)
public class FileUploadController {
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception{
        System.out.println(description);
        if(!file.isEmpty()){
            String path = request.getServletContext().getRealPath("/file");
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator + filename));
            return "success";
        }else{
            return "error";
        }
    }
}
