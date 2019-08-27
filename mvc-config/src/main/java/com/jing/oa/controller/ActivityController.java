package com.jing.oa.controller;

import com.jing.oa.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public ModelAndView insert() {
        return new ModelAndView("activity");
    }
}
