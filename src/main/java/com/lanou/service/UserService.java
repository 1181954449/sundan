package com.lanou.service;

import com.lanou.entity.User;

/**
 * Created by lanou on 2018/4/3.
 */

public interface UserService {
    // 用户名注册
    public int userReg(User user,String valicationImg);
    // 用户使用手机号码注册
    public int userPhoneReg(User user,String valicationImg,String text);
    // 用户登录
    public User userLogin(User user);
    // 用户修改密码
    public int updatePasswordUser(User user,String userPassword);
    // 用户未登录
    public User updateNoLoginPasswordUser(User user);
    // 用户未登录修改密码最后一步
    public int updateOverPasswordUser(User user);
    // 查询手机验证码
    public User phoneCode(User user);
    // 修改手机号码
    public int alterPhone(User user);
    // 修改支付密码
    public int alterPayPass(User user);
    // 添加发票
    public int saveBill(User user);

}
