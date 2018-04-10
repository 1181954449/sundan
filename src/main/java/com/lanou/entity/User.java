package com.lanou.entity;

/**
 * Created by lanou on 2018/4/3.
 */
public class User {
    /**
     * 用户ID
     * 用户名
     * 用户登录密码
     * 用户手机号码
     * 用户头像
     * 用户邮箱
     * 用户最后一次登录时间
     * 用户支付密码
     */
    private int userId;
    private String userName;
    private String userPassword;
    private String userPhone;
    private String userHeadimg;
    private String userEmail;
    private String userDate;
    private String userPayPass;
    private Bill bill;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userHeadimg='" + userHeadimg + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userDate='" + userDate + '\'' +
                ", userPayPass='" + userPayPass + '\'' +
                ", bill=" + bill +
                '}';
    }

    public String getUserPayPass() {
        return userPayPass;
    }

    public void setUserPayPass(String userPayPass) {
        this.userPayPass = userPayPass;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public User() {
    }

}
