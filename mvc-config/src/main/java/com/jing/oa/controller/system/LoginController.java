package com.jing.oa.controller.system;

import com.jing.oa.model.LoginVerifyToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author GuoJingyuan
 * @date 2019/8/22
 */
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String account, String password) {
        ModelAndView result = new ModelAndView();
        result.setViewName("login");
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)) {
            result.addObject("tip","账号或密码不能为空");
        }
        try {
            LoginVerifyToken token = new LoginVerifyToken();
            token.setUsername(account);
            token.setPassword(password.toCharArray());
            SecurityUtils.getSubject().login(token);
            result.setViewName("redirect:hello");
        } catch (AuthenticationException e) {
//            e.printStackTrace();
            logger.error("login失败：", e);
            result.addObject("tip", e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        SecurityUtils.getSubject().logout();
        return new ModelAndView("redirect:hello");
    }
}
