package com.lanou.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/3.
 */
public class Util {
    public static  String getMD5(String md5){
        String passMD5 = null;
        try {
            // 生成一个md5加密摘要
            MessageDigest md51 = MessageDigest.getInstance("md5");
            // 计算md5函数
            md51.update(md5.getBytes());
            //
            passMD5 = new BigInteger(1,md51.digest()).toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  passMD5;
    }
    public static String convertJson(int n,String msg){
        Map<String,Object> maps = new HashMap();
        maps.put("errorCode",n);
        maps.put("msg",msg);
        String json = JSON.toJSONString(maps);
        return json;
    }
    public static String convertJson(List list,int n){
        Map<String,Object> maps = new HashMap<>();
        maps.put("type",list);
        maps.put("errorCode",n);
        String json = JSON.toJSONString(maps);
        return json;
    }
    public static PrintWriter getWriter(HttpServletResponse response){
        PrintWriter writer =null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return writer;
    }
    public static  void crossomain(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
    }
}
