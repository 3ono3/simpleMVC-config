package com.jing.oa.controller;

import com.jing.oa.common.CustomerException;
import com.jing.oa.common.JsonResult;
import com.jing.oa.model.User;
import com.jing.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author GuoJingyuan
 * @date 2019/8/12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert.do")
    @ResponseBody
    public JsonResult insert() {
        try {
            User user = new User();
            user.setUserId("1234");
            user.setUserName("莉莉娅");
            int num = userService.insert(user);
            return JsonResult.ok();
        } catch (CustomerException e) {
            return JsonResult.error(e);
        } catch (Exception e) {
            return JsonResult.unexpectedError();
        }
    }
}
