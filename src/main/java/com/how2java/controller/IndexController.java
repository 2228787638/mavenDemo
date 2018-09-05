package com.how2java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/index")
public class IndexController {
    /**
     * 主页面
     */
    @RequestMapping(value="/index")
    public ModelAndView gotoIndex(ModelAndView mv){

        // 转发到main请求
        mv.setViewName("index");

        return mv;
    }
}
