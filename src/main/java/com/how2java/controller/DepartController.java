package com.how2java.controller;

import com.github.pagehelper.PageInfo;
import com.how2java.domain.Depart;
import com.how2java.domain.User;
import com.how2java.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2018/9/8.
 */
@Controller
@RequestMapping(value = "/depart")
public class DepartController {
    /**
     * 自动注入DepartService
     * */
    @Autowired
    @Qualifier("departService")
    private DepartService departService;
    /**
     * 部门管理页面
     */
    @RequestMapping(value="/departList")
    public ModelAndView gotoIndex(ModelAndView mv,@RequestParam(value = "pageNum",required=true,defaultValue="1") Integer pageNum,
                                  @RequestParam(value = "pageSize",required=false,defaultValue="10") Integer pageSize){
        PageInfo<Depart> pageInfo= departService.getDepartList(pageNum,pageSize);

        mv.addObject("departList", pageInfo);

        mv.setViewName("depart/depart");

        return mv;
    }

    @RequestMapping(value="/goToNewDepartInsert")
    public ModelAndView goToNewDepartInsert(ModelAndView mv){
        mv.setViewName("depart/departInsert");
        return mv;
    }

    @RequestMapping(value="/departInsert",method = RequestMethod.POST)
    public ModelAndView departInsert(ModelAndView mv, @ModelAttribute Depart depart){
        departService.insert(depart);
        mv.setViewName("depart/departInsert");
        System.out.println(depart.getDepartname());
        return mv;
    }

    @RequestMapping(value = "/departRemove", method = RequestMethod.GET)
    public String departRemove(ModelAndView mv, @RequestParam(value = "id") Integer id){
        Integer ID = departService.remove(id);
        return "redirect:departList";
    }

    @RequestMapping(value= "/departModify")
    public ModelAndView goToDepartModified(ModelAndView mv, @RequestParam(value = "id") Integer id){
        Depart modify = departService.modified(id);
        mv.addObject("depart",modify);
        mv.setViewName("depart/departModified");
        return mv;
    }

    @RequestMapping(value="/departModified", method = RequestMethod.POST)
    public String departModify(ModelAndView mv, @ModelAttribute Depart depart){
        Depart depart1 = departService.modified(depart.getId());
        depart1.setDepartname(depart.getDepartname());
        depart1.setDescription(depart.getDescription());
        depart1.setPersoncount(depart.getPersoncount());
        departService.update(depart1);
        return "redirect:departList";
    }

    @RequestMapping(value= "/departDisplayUser")
    public ModelAndView goToDepartDisplayUser(ModelAndView mv, @RequestParam(value = "id") Integer id,
                                              @RequestParam(value = "pageNum",required=true,defaultValue="1") Integer pageNum,
                                              @RequestParam(value = "pageSize",required=false,defaultValue="10") Integer pageSize){
        PageInfo<User> userPageInfo = departService.displayDepartUser(id,pageNum,pageSize);
        mv.addObject("userPageInfo", userPageInfo);
        mv.setViewName("depart/departDisplayUser");
        return mv;
    }
}
