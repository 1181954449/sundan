package com.lanou.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lanou on 2018/4/3.
 */
public class MessageUtil {
    public static void main(String arg[]){
        MessageUtil msg = new MessageUtil();
        msg.getMsg("15152268067");
    }
    // 短信应用SDK AppID
    int appid = 1400077121; // 1400开头

    // 短信应用SDK AppKey
    String appkey = "ebabd41d154b479aca6d2f96da2739a6";

    int tmpId = 97213;
    // 签名
    String smsSign = "顺电"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    public String getMsg(String phone){
        String code = code();
        try {
            int appid = 1400077121;
            String appkey = "ebabd41d154b479aca6d2f96da2739a6";
            int tmplId = 97213;
            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult singleSenderResult;

            ArrayList<String> params = new ArrayList<String>();
            params.add(code);
            params.add("3");
            singleSenderResult = singleSender.sendWithParam("86", phone, tmplId, params, "小超科技", "", "");
            System.out.println(singleSenderResult);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return code;
    }
    // 随机生成验证码
    public static String code() {
        Random random = new Random();
        int safeCode = random.nextInt(9999-1000+1)+1000;
        String safeCodes = String.valueOf(safeCode);
        return safeCodes;
    }
}
