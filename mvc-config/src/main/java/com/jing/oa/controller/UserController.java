package com.jing.oa.controller;

import com.jing.oa.common.CustomerException;
import com.jing.oa.common.JsonResult;
import com.jing.oa.model.User;
import com.jing.oa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView insert() {
        return new ModelAndView("user");
    }

    @RequestMapping("/getById")
    @ResponseBody
    public JsonResult selectById(String userId) {
        try {
            User user = userService.selectById(userId);
            return JsonResult.ok(user);
        }catch (CustomerException e) {
            return JsonResult.error(e);
        } catch (Exception e) {
            return JsonResult.unexpectedError();
        }
    }
}
