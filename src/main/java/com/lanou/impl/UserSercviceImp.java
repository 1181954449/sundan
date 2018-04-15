package com.lanou.impl;

import com.lanou.dao.UserDao;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.ImgUtil;
import com.lanou.util.RegUtil;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lanou on 2018/4/3.
 */
@Service("userService")
public class UserSercviceImp implements UserService{

    @Autowired
    private UserDao userDao;
    // 用户直接注册
    public int userReg(User user,String valicationImg){
        int count = 0;

        String userPassword = user.getUserPassword();
        userPassword = Util.getMD5(userPassword);
        user.setUserPassword(userPassword);
        // 注册成功返回值为 1
        count = userDao.userReg(user);
        System.out.print(count);

        return count;
    }
    // 查看用户手机号码是否被注册
    @Override
    public User phoneCode(User user) {
        // 从数据库中查询该手机号是否被注册
        User phone = userDao.findUserPhone(user);
        return phone;
    }
    // 用户使用手机号码注册
    public int userPhoneReg(User user,String valicationImg,String text) {
        int i = 0;
        // 从数据库中查询该手机号是否被注册
        User phone = userDao.findUserPhone(user);
        // 如果没有查到
        if (phone == null){
            // 则进行用户注册
            String userPassword = user.getUserPassword();
            userPassword = Util.getMD5(userPassword);
            user.setUserPassword(userPassword);
            i = userDao.userPhoneReg(user);
            // 并且返回i
            return i;
        }
        // 如果查到了
        // 返回i= 1024;
        return  i = 1024;
    }
    // 用户使用用户名和密码等录
    @Override
    public User userLogin(User user) {
        // 判断是否为手机号码登录
        if (RegUtil.isPhone(user.getUserName())){
            return userDao.userPhoneLogin(user);
            // 判断是否为邮箱登录
        }else if (RegUtil.isEmail(user.getUserName())){
            return userDao.userEmailLogin(user);
        }
        return userDao.userLogin(user);
    }
    // 修改密码
    @Override
    public int updatePasswordUser(User user,String userPassword) {
        User userPhone = userDao.findUserPhone(user);
        String md5 = Util.getMD5(userPassword);
        user.setUserPassword(md5);
        int i = userDao.updatePasswordUser(user);
        return i;
    }
    // 未登录修改密码
    public User updateNoLoginPasswordUser(User user){
        String userName = user.getUserName();
        // 判断是否为手机号码登录
        if (RegUtil.isPhone(user.getUserName())){
            return userDao.userPhoneLogin(user);
            // 判断是否为邮箱登录
        }else if (RegUtil.isEmail(user.getUserName())){
            return userDao.userEmailLogin(user);
        }
        return user;
    }
    // 未登录修改密码最后一步
    @Override
    public int updateOverPasswordUser(User user) {
        int count = userDao.updateOverPasswordUser(user);
        return count;
    }
    // 通过确认密码,来修改支付密码
    @Override
    public int alterPhone(User user) {
        return userDao.alterPhone(user);
    }
    // 通过确认密码,来修改支付密码
    @Override
    public int alterPayPass(User user) {
        int count = userDao.alterPayPass(user);
        return count;
    }
    // 添加发票信息
    @Override
    public int saveBill(User user) {
        return userDao.saveBill(user);
    }
}
