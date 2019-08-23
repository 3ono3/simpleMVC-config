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

    @RequestMapping("/insert.do")
    @ResponseBody
    public JsonResult insert() {
        logger.info("请求路径----");
        try {
            User user = new User();
            user.setId("1234");
            user.setName("莉莉娅");
            int num = userService.insert(user);
            return JsonResult.ok();
        } catch (CustomerException e) {
            return JsonResult.error(e);
        } catch (Exception e) {
            return JsonResult.unexpectedError();
        }
    }

    @RequestMapping("/get")
    @ResponseBody
    public JsonResult selectById() {
        try {
            User user = userService.selectById("1234");
            return JsonResult.ok(user);
        }catch (CustomerException e) {
            return JsonResult.error(e);
        } catch (Exception e) {
            return JsonResult.unexpectedError();
        }
    }
}
