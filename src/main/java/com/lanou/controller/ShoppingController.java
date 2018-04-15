package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.entity.ShoppingCar;
import com.lanou.entity.User;
import com.lanou.service.ShoppingCarService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/4.
 */
@Controller
@RequestMapping("/shop")
public class ShoppingController {
    @Autowired
    private ShoppingCarService shoppingCarService;

    @RequestMapping("/list")
    public String getGoodsList(HttpServletResponse response, Model model, int goodsId) {

        List<Goods> goodsList = shoppingCarService.findOrderListByGoodsId(goodsId);

        System.out.println("goodsList方法执行了");
        Map<String, Object> maps = new HashMap();
        maps.put("errorcode", 0);
        maps.put("msg", "请求成功");
        maps.put("goodsList", goodsList);
        String json = JSON.toJSONString(maps);
        //       控制台测试
        System.out.println(json);
        //      页面测试
        model.addAttribute("goods", json);
        try {
            response.getWriter().append(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Test";
    }

    @RequestMapping("/add")
    public void addShoppingCar(HttpServletResponse response, HttpSession session, ShoppingCar sc) {
        User user = (User) session.getAttribute("user");
//        sc.setUserId(user.getUserId());
        sc.setUserId(1);
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        List<Goods> goodsList = shoppingCarService.add(sc);
        if(goodsList != null){
            json = Util.creatJson(1, "购物车添加成功", goodsList);
        }else {
            json = Util.convertJson(0, "购物车添加失败");
        }
        writer.append(json);
    }

    @RequestMapping("/delete")
    public void deleteShop(HttpServletResponse response,HttpSession session, ShoppingCar sc) {
        User user = (User) session.getAttribute("user");
        //        sc.setUserId(user.getUserId());
        sc.setUserId(1);
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int count = shoppingCarService.delete(sc);
        System.out.println("deleteShop方法执行了");
        if(count > 0){
            json = Util.convertJson(1, "删除成功");
        }else {
            json = Util.convertJson(1, "删除失败");
        }
        writer.append(json);
    }


}
