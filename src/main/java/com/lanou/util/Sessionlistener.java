package com.lanou.util;

import com.lanou.entity.User;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

/**
 * Created by lanou on 2018/4/11.
 */
public class Sessionlistener implements HttpSessionListener {
    // session创建时执行的方法?
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("session创建时运行的方法");
    }
    // session摧毁时执行的方法?
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("session摧毁时运行的方法");
        HttpSession session = httpSessionEvent.getSession();
        String id = session.getId();
        // 在session销毁的时候,把loginUserMap中保存的键值对清除
        User user = (User) session.getAttribute("now_user");
        if (user!=null){
            Map<String, String> loginUserMap = (Map<String, String>) httpSessionEvent.getSession().getServletContext().getAttribute("loginUserMap");
            if (loginUserMap.get(user.getUserName()).equals(id)){
                loginUserMap.remove(user.getUserName());
                httpSessionEvent.getSession().getServletContext().setAttribute("loginUserMap",loginUserMap);
            }
        }
    }
}
