package com.lanou.Interceptor;

import com.alibaba.fastjson.JSON;
import com.lanou.util.RegUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanou on 2018/4/3.
 */
public class UserInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 创建一个map集合 添加数据
        Map<String,Object> jsonMap = new HashMap();
        // 获取字符流
        PrintWriter writer = response.getWriter();
        // 获取前端发送的用户名
        String userName = request.getParameter("userName");
        // 获取前端发送的用户密码
        String userPassword = request.getParameter("userPassword");
        // 获取前端发送的重复密码
        String confirmPassword = request.getParameter("confirmPassword");
        request.getParameter("");
        // 定义一个字符串
        String json = null;
        if(!(userName.length() > 4) && !(userName.length() < 15)){
            // 添加json数据到map中
            jsonMap.put("errocCode",3);
            jsonMap.put("msg","用户名长度在4~15之间");
            json = JSON.toJSONString(jsonMap);
            // 通过字符流将json发送到前端
            writer.append(json);
            // return false 将请求拦截 返回true 请求继续
            return false;
        } else if (!userPassword.equals(confirmPassword) ){
            jsonMap.put("errorCode",4);
            jsonMap.put("msg","两次密码输入的不正确");
            json = JSON.toJSONString(jsonMap);
            writer.append(json);
            return  false;
        }else {
            return  true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
