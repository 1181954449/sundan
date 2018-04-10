package com.lanou.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lanou on 2018/4/3.
 */
public class RegUtil {

    public static void main(String arg[]){
        boolean phone = isPhone("15152268067");
        System.out.print(phone);
    }
    public static boolean isPhone(String phone){
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        boolean isMatch = m.matches();
        return  isMatch;
    }

    public  static boolean isEmail(String email){
        String regex = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean isMatch = m.matches();
        return  isMatch;
    }
}
