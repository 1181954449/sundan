package com.lanou.test;

import com.lanou.entity.User;
import com.lanou.service.UserService;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lanou on 2018/4/3.
 */

public class UserTest {
    @Autowired
    private UserService userService;
    // 用户注册单元测试
    @Test
    public void userReg(){
        User user = new User();
        user.setUserName("gssnb");
        user.setUserPassword("584521");
//        int i = userService.userReg(user);
//        System.out.print(i);
    }
}
