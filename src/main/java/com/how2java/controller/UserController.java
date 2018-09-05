package com.how2java.controller;

import com.github.pagehelper.PageInfo;
import com.how2java.domain.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/user")
public class UserController {

    /**
     * 自动注入UserService
     * */
    @Autowired
    @Qualifier("userService")
    private UserService userService;
    /**
     * 用户管理页面
     */
    @RequestMapping(value="/userList")
    public ModelAndView gotoIndex(ModelAndView mv,@RequestParam(value = "pageNum",required=true,defaultValue="1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required=false,defaultValue="10") Integer pageSize){
        PageInfo<User> pageInfo= userService.getUserList(pageNum,pageSize);

        mv.addObject("userList", pageInfo);

        mv.addObject("message","恭喜");

        mv.setViewName("user");

        return mv;
    }
}
