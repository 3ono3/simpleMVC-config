package com.jing.oa.interceptor;

import com.jing.oa.model.User;
import com.jing.oa.util.HttpUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author GuoJingyuan
 * @date 2019/8/27
 */
public class MonitorInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        //获取ip
        String ip = HttpUtil.getIpAddress(request);
        //用户名
        String userAccount = null;
        try {
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            userAccount = user.getAccount();
        } catch (Exception e) {
            logger.error("MonitorInterceptor get user error");
        }
        //请求地址
        String requestURI = request.getRequestURI();
        //请求参数
        Map<String, Object> parameterMap = request.getParameterMap();

        //开始时间
        long startTime = System.currentTimeMillis();
        request.setAttribute("userAccount", userAccount);
        request.setAttribute("startTime", startTime);
        request.setAttribute("requestUri", requestURI);

        logger.info("---request start[" + "user:" + userAccount + ", ip:" + ip + ", uri:" + requestURI + ", parameterMap:" + parameterMap + "]");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        String userAccount = (String) request.getAttribute("userAccount");
        long startTime = (long) request.getAttribute("startTime");
        String requestUri = (String) request.getAttribute("requestUri");

        long endTime = System.currentTimeMillis();
        long handleTime = endTime - startTime;

        logger.info("---request end[" + "user:" + userAccount + ", uri:" + requestUri + ", handleTime:" + handleTime + "ms]");
    }
}
