package com.jing.oa.controller;

import com.alibaba.fastjson.JSONObject;
import com.jing.oa.model.User;
import com.jing.oa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/insert.do")
    @ResponseBody
    public String insert() {
        User user = new User();
        user.setUserId("1234");
        user.setUserName("莉莉娅");
        int num = userService.insert(user);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("success", true);
        jsonObject.put("num", num);
        return jsonObject.toJSONString();
    }
}
