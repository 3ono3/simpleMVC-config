package com.jing.oa.controller;

import com.jing.oa.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoJingyuan
 * @date 2019/8/10
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        mv.addObject("haha","欢迎您"+user.getName());
        return mv;
    }
}
