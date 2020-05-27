package com.feige.tymeleaf.controller;


import com.feige.tymeleaf.common.Pager;
import com.feige.tymeleaf.common.Result;
import com.feige.tymeleaf.common.StatusCode;
import com.feige.tymeleaf.entity.Test;
import com.feige.tymeleaf.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("")
public class TestController {

    @Autowired
    TestService testServiceImpl;

    @RequestMapping(value="")
    public ModelAndView test(@RequestParam Map<String,String> map) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        Pager<Test> pager = testServiceImpl.findAll(map,2);
        mv.addObject("listAll", pager.getPageContent());
        mv.addObject("pageTotal", pager.getPageTotal());
        mv.addObject("page", pager.getCurrentPage());
        mv.addObject("Result","查询成功！");
        return mv;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ModelAndView save(@RequestParam Map<String,String> map) throws Exception {
        ModelAndView mv = new ModelAndView("index");
        try{
            testServiceImpl.save(map);
            mv.addObject("Result",map.get("msg")+"成功！");
        }catch (Exception e){
            mv.addObject("Result",map.get("msg")+"失败！");
        }
        return mv;
    }

    @RequestMapping(value="/del",method = RequestMethod.POST)
    public ModelAndView del(int id) throws Exception {
        testServiceImpl.del(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("Result","删除成功!");
        return mv;
    }
}
