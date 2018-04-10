package com.lanou.Interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanou on 2018/4/3.
 */
public class UserUpdateInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> maps = new HashMap();
        String contrimPassword = (String) request.getAttribute("contrimPassword");
        if (contrimPassword==null){
            maps.put("errorCode",1997);
            maps.put("msg","请先确认密码在进行修改");
            response.getWriter().append(JSON.toJSONString(maps));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
