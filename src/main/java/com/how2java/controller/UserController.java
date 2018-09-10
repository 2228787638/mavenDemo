package com.how2java.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.github.pagehelper.PageInfo;
import com.how2java.domain.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping(value="/user")
@SessionAttributes("user")
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

    @RequestMapping(value="/goToNewInsert")
    public ModelAndView goToUserInsert(ModelAndView mv){
        mv.setViewName("insert");
        return mv;
    }

    @RequestMapping(value="/userInsert",method = RequestMethod.POST)
    public ModelAndView userInsert(ModelAndView mv, @RequestParam(value = "loginname") String loginname,
                                  @RequestParam(value = "password") String password){
        String message=userService.insert(loginname,password);
        mv.addObject("message",message);
        mv.setViewName("insert");
        return mv;
    }

    @RequestMapping(value="/goToRegister")
    public ModelAndView goToUserRegister(ModelAndView mv){
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView userRegister(ModelAndView mv, @RequestParam(value = "loginname") String loginname,
                                   @RequestParam(value = "password") String password){
        String message=userService.insert(loginname,password);
        mv.addObject("message",message);
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping(value="/gotologin")
    public ModelAndView gotoSubmit(ModelAndView mv){
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String userSubmit(Model model, @RequestParam(value = "loginname") String loginname,
                             @RequestParam(value = "password") String password){
        String message = userService.login(loginname,password);
        if(message.equals("登录成功")){
            model.addAttribute(userService.getUserByLoginname(loginname));
            return "redirect:userList";
        }else if (message.equals("登录失败")){
            return "redirect:gotologin";
        }else{
            return "redirect:gotologin";
        }
    }

    @RequestMapping(value = "/userRemove", method = RequestMethod.GET)
    public String userRemove(ModelAndView mv, @RequestParam(value = "id") Integer id){
        Integer ID = userService.remove(id);
        return "redirect:userList";
    }

    @RequestMapping(value= "/userModify")
    public ModelAndView goToUserModified(ModelAndView mv, @RequestParam(value = "id") Integer id){
        User modify = userService.modified(id);
        mv.addObject("user",modify);
        mv.setViewName("modified");
        return mv;
    }

    @RequestMapping(value="/userModified", method = RequestMethod.POST)
    public String userModify(ModelAndView mv, @ModelAttribute User user){
        User userpojo = userService.modified(user.getId());
        userpojo.setLoginname(user.getLoginname());
        userpojo.setPassword(user.getPassword());
        userpojo.setRole(user.getRole());
        userService.update(userpojo);
        return "redirect:userList";
    }
/*
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("desciption") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        if(!file.isEmpty()){
            String path = request.getServletContext().getRealPath("/images");
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator+filename));
            return "success";
        }else{
            return "error";
        }
    }
    */
}
