package com.lanou.dao;

import com.lanou.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * Created by lanou on 2018/4/3.
 */
@Repository
public interface UserDao {
    // 用户名注册
    public int userReg(User user);
    // 使用手机号码注册
    public int userPhoneReg(User user);

    // 查询该手机号是否被注册
    public User findUserPhone(User user);

    // 用户登录
    public User userLogin(User user);
    // 用户手机号码登录
    public User userPhoneLogin(User user);
    // 用户邮箱登录
    public User userEmailLogin(User user);
    // 获取用户对象
    public User findPasswordUser(User user);
    // 更新修改用户密码
    public int updatePasswordUser(User user);

    // 未登录用户修改密码
    public int updateOverPasswordUser(User user);
    // 修改手机号码
    public int alterPhone(User user);
    // 修改支付密码
    public int alterPayPass(User user);
    // 添加发票
    public int saveBill(User user);

}
