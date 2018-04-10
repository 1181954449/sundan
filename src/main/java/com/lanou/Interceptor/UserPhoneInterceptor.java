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
public class UserPhoneInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userCode = request.getParameter("userCode");
        String userPassword = request.getParameter("userPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        if (userCode.length()==0){
            Map<String,Object> map = new HashMap<>();
            map.put("errorCode",13);
            map.put("msg","手机验证码不能为空");
            String json = JSON.toJSONString(map);
            response.getWriter().append(json);
            return  false;
        }
        if (!userPassword.equals(confirmPassword)){
            Map<String,Object> map = new HashMap<>();
            map.put("errorCode",1314);
            map.put("msg","两次密码输入不一致");
            String json = JSON.toJSONString(map);
            response.getWriter().append(json);
            return  false;
        }
        if (userPassword == null|| confirmPassword == null){
            Map<String,Object> map = new HashMap<>();
            map.put("errorCode",2008);
            map.put("msg","密码不能为空");
            String json = JSON.toJSONString(map);
            response.getWriter().append(json);
            return  false;
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
