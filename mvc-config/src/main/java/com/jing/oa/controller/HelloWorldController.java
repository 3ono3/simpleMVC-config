package com.jing.oa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoJingyuan
 * @date 2019/8/10
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/oa/hello.do", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("haha","HAHAHA");
        return mv;
    }

    @RequestMapping(value = "/oa/hello2.do", method = RequestMethod.GET)
    public ModelAndView helloWorld2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:/oa/hello.do");
        return mv;
    }
}
