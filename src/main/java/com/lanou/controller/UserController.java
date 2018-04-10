package com.lanou.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Bill;
import com.lanou.entity.User;
import com.lanou.service.UserService;
import com.lanou.util.ImgUtil;
import com.lanou.util.MessageUtil;
import com.lanou.util.RegUtil;
import com.lanou.util.Util;
//import com.mchange.v1.identicator.IdHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * Created by lanou on 2018/4/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public static String code = null;

    public static String text = null;
    // 用户注册请求
    @RequestMapping("/userReg")
    @ResponseBody
    public Map<String, Object> userReg(User user, String valicationImg, HttpServletResponse response) {
        // 返回值: 1 注册成功
        // -1 验证码输入错误
        Map<String, Object> maps = new HashMap();
        System.out.print(userService);
        int i = userService.userReg(user, valicationImg);
        String json = "{\"errorCode\":" + i + "}";
        try {
            Util.crossomain(response);
            response.getWriter().append(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        // i的值为1表示注册成功
        // 为2 表示验证码填写错误
        maps.put("errorCode", i);
        return maps;
    }

    // 用户验证码请求
    @RequestMapping("/valicationImg")
    public void valicationImg(HttpServletResponse response) throws IOException {
        PrintWriter writer = Util.getWriter(response);
        ImgUtil img = new ImgUtil();
        BufferedImage image = img.createImage();
        text = img.getText();
        ImgUtil.output(image, response.getOutputStream());
        Map<String,Object> map = new HashMap<>();
        map.put("text",text);
        writer.append(JSON.toJSONString(map));
    }
    // 手机验证码请求
    @RequestMapping("/phoneCode")
    public void phoneCode(User user,HttpServletResponse response) {
        Util.crossomain(response);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> maps = new HashMap();
        // 判断是否为正确的手机号
        if (RegUtil.isPhone(user.getUserName())) {
            user.setUserPhone(user.getUserName());
            User phone = userService.phoneCode(user);
            if (phone==null){
                // 获取用户输入的手机号码
                String userName = user.getUserName();
                // 创建发送短信对象
                MessageUtil msg = new MessageUtil();
                // 获取到验证码 向用户发送验证码
                code = msg.getMsg(userName);
                System.out.println(code);
                maps.put("Code",code);
                maps.put("msg","您的验证码为:" + code);
                String s = JSON.toJSONString(maps);
                writer.append(s);
                return;
            }
            if (phone!=null){
                writer.append(Util.convertJson(10,"您的手机号码已经被注册"));
                return;
            }
        }
        maps.put("errorCode",2048);
        maps.put("msg","请输入正确的手机号");
        String json = JSON.toJSONString(maps);
        writer.append(json);
    }

    // 手机注册请求
    @RequestMapping("/userPhoneReg")
    public void userPhoneReg(User user,String valicationImg,HttpServletResponse response){
        System.out.println("用户:" + user+"图形验证码:"+valicationImg);
        PrintWriter writer = null;
        Util.crossomain(response);
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap();
        // 获取用户输入的手机号码
        String userName = user.getUserName();
        System.out.print(code);
        // 判断用户输入的时候是正确的手机号
        if (RegUtil.isPhone(userName)){
            // 是正确手机号码将手机号码存入的对象中
            user.setUserPhone(userName);
            // 返回值为1  : 注册成功
            // 其他为失败
            int i = userService.userPhoneReg(user,valicationImg,text);
            map.put("errorCode",i);
            map.put("msg","1:注册成功,其他:注册失败");
            writer.append(JSON.toJSONString(map));
            return;
        }
    }

    // 登录
    @RequestMapping("/userLogin")
    public void userLogin(User user, HttpServletRequest request,HttpServletResponse response){
        Util.crossomain(response);
        System.out.print(user);
        PrintWriter writer = null;
        // 将密码转换为md5加密
        user.setUserPassword(Util.getMD5(user.getUserPassword()));
        System.out.print(user);
        try {
            // 获取写入流
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        // 调用服务层查询user
        User loginUser = userService.userLogin(user);
        Map<String,Object> maps = new HashMap<>();
        String json = null;
        if (loginUser!=null){
            // 如果查询出来的用户不为空,则代表查询成功,将对象塞进session中
            session.setAttribute("user",loginUser);
            maps.put("errorCode",2018);
            maps.put("msg","登录成功");
            // 将map转换为json
            json = JSON.toJSONString(maps);
        }else {
            maps.put("errorCode",2019);
            maps.put("msg","登录失败");
            // 将map转换为json
            json = JSON.toJSONString(maps);
        }
        // 发送json字符串
        writer.append(json);
    }
    // 修改密码之前的确认密码
    @RequestMapping("/confirmPasswordUser")
    public void confirmPasswordUser(String userPassword,HttpServletRequest request,HttpServletResponse response){
        Util.crossomain(response);
        PrintWriter writer = null;
        try {
            // 获取输入流
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        // 获取session并获取登录的用户信息
        User user = (User) request.getSession().getAttribute("user");
        // 确认密码信息md5加密
        String md5 = Util.getMD5(userPassword);
        String userPassword1 = user.getUserPassword();
        // 将加密后的md5密码与原密码进行匹配
        if (md5.equals(userPassword1)){
            // 将密码添加到request中
            try {
                request.setAttribute("contrimPassword",md5);
                // 成功添加标记0 ,密码确认成功
                map.put("errorCode",0);
                map.put("msg","密码确认成功");
                writer.append( JSON.toJSONString(map));
                request.getRequestDispatcher("/resource/views/updatePassword.jsp").forward(request,response);
                return;
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // 失败标记1 ,密码确认失败
        map.put("errorCode",1);
        map.put("msg","密码确认失败");
        writer.append( JSON.toJSONString(map));
    }
    // 确认过密码之后登录密码修改
    @RequestMapping("/updatePasswordUser")
    public void updatePasswordUser(String userPassword,HttpServletRequest request,HttpServletResponse response){
        Util.crossomain(response);
        Map<String,Object> map = new HashMap<>();
        // 获取写入流
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取session 中的user对象
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        // 返回值为1时 修改成功,
        // 返回值为其他  修改失败
        int count = userService.updatePasswordUser(user,userPassword);
        map.put("errorCode",count);
        map.put("msg","1:修改成功,其他:修改失败");
        // 将Map集合转换为json字符串
        String json = JSON.toJSONString(map);
        writer.append(json);
    }
    // 未登录状态下修改密码,前端传来用户名,手机号码,QQ邮箱,来更改密码
    @RequestMapping("/updateNoLoginPasswordUser")
    public void updateNoLoginPasswordUser(User user,HttpServletResponse response){
        Util.crossomain(response);
        // 获取一个map集合
        Map<String,Object> maps = new HashMap<>();
        // 通过服务层进行该对象查询
        User findUser = userService.updateNoLoginPasswordUser(user);
        // 如果查询的对象不等于空说明,有该用户
        if (findUser!=null){
            // 获取该用户的手机号码
            String userPhone = findUser.getUserPhone();
            // 将手机号添加到map中
            maps.put("phone",userPhone);
            maps.put("msg","手机号码");
            try {
                // 利用response发送json字符串
                response.getWriter().append(JSON.toJSONString(maps));
                // return 结束方法
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 如果对象等于空,就说明没有该用户
        maps.put("phone","没有该用户");
        maps.put("msg","诶有该用户");
        try {
            response.getWriter().append(JSON.toJSONString(maps));
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 确认有该用户了进行下一步操作
    @RequestMapping("/updateNextPassword")
    public void updateNextPassword(String userCode,String valicationImg,HttpServletResponse response){
        Util.crossomain(response);
        PrintWriter writer = null;
        try {
            // 获取发送流
             writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 创建一个map
        Map<String,Object> map = new HashMap<>();
        // 创建一个图片工具类的对象
        ImgUtil imgUtil = new ImgUtil();
        // 获取图片的文本信息
        String text = imgUtil.getText();
        // 进行忽略大小写操作
        text = text.toUpperCase();
        // 前端发送的图片验证码
        valicationImg = valicationImg.toUpperCase();
        // 判断用户输入的手机验证码是否正确
        if (!userCode.equals(code)){
            // 如果不正确,那么手机验证码错误
            map.put("errorCode",0);
            map.put("msg","手机验证码错误");

            writer.append(JSON.toJSONString(map));
            return;
        }
        // 如果图形验证码不正确
        else if (!valicationImg.equals(text)){
            // 发送图形验证码错误
            map.put("errorCode",1);
            map.put("msg","图形验证码错误");
            writer.append(JSON.toJSONString(map));
            return;
        }
        // 如果以上没有匹配到,则匹配成功,可以进行下一步修改密码操作
        map.put("errorCode",2);
        map.put("msg","匹配成功可以进行下一步");
        writer.append(JSON.toJSONString(map));
        return;
    }
    // 修改密码操作,前端发送一个手机号码,一个用户密码,一个重复输入密码
    @RequestMapping("/updateOverPasswordUser")
    public void updateOverPasswordUser(User user,String confirmPassword,HttpServletResponse response) {
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        Map<String, Object> map = new HashMap<>();
        if (!user.getUserPassword().equals(confirmPassword)) {
            writer.append(Util.convertJson(0, "两次密码输入不一致"));
        } else {
            int count = userService.updateOverPasswordUser(user);
            writer.append(Util.convertJson(count, "1:修改成功,其他:修改失败"));
        }
    }
    // 修改手机号码
    @RequestMapping("/alterPhone")
    public void alterPhone(String userPhone,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUserPhone(userPhone);
        int count = 0;
        try {
            count = userService.alterPhone(user);
        }catch (Exception e){

        }
        PrintWriter writer = Util.getWriter(response);
        writer.append(Util.convertJson(count,"1:修改成功,其他:修改失败"));
    }
    // 修改支付密码
    @RequestMapping("/alterPayPass")
    public void alterPayPass(String userPayPass,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setUserPayPass(userPayPass);
        int count = 0;
        try{
            count = userService.alterPayPass(user);
        }catch (Exception e){

        }
        PrintWriter writer = Util.getWriter(response);
        writer.append(Util.convertJson(count,"1:修改成功,其他:修改失败"));
    }
    // 添加抬头发票
    @RequestMapping("/addUserBill")
    public void addUserBill(Bill bill,HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("user");
        users.setBill(bill);
        int count = userService.saveBill(users);
        Util.getWriter(response).append(Util.convertJson(count,"1:添加成功,其他:添加失败"));
    }
}
