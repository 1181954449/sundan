package com.lanou.controller;

import com.lanou.entity.Goods;
import com.lanou.entity.Order;
import com.lanou.entity.User;
import com.lanou.service.OrderService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by gaozhichao on 2018/4/4.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    // 添加订单
    @RequestMapping("/addOrder")
    public void addOrder(HttpServletResponse response, Order order){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int count = orderService.addOrder(order);
        if(count > 0){
            json = Util.convertJson(1, "订单添加成功");
        }else {
            json = Util.convertJson(0, "订单添加失败");
        }
        writer.append(json);
    }

    // 点击购买
    @RequestMapping("/buy")
    public void buyGoods(HttpServletResponse response, HttpSession session, int[] goodsId){
        User user1 = (User) session.getAttribute("user");
        User user = new User();
        user.setUserId(1);

        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        Order order = orderService.buygoods(user.getUserId());
        List<Goods> goodss = new ArrayList<>();
        for (int i = 0; i< goodsId.length; i++){
            System.out.println(goodsId[i]);
            Goods goods = orderService.findAllGoods(goodsId[i]);
            System.out.println(goods);
            goodss.add(goods);
        }
        order.setGoodss(goodss);
        if(goodss == null){
            json = Util.convertJson(0, "生成失败");
        }else {
            json = Util.creatJson(0, "生成成功", order);
        }
        writer.append(json);

    }

    //删除订单
    @RequestMapping("/delete")
    public void deleteOrder(HttpServletResponse response, int orderId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int count = orderService.deleteOrder(orderId);
        if(count > 0) {
            json = Util.convertJson(1, "订单删除成功");
        }else {
            json = Util.convertJson(0, "订单删除失败");
        }

        writer.append(json);
    }
    // 查看所有订单
    @RequestMapping("/findAllOrder")
    public void findAllOrder(HttpServletResponse response, int userId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        List<Order> allOrder = orderService.findAllOrder(userId);
        if(allOrder != null) {
            json = Util.creatJson(1, "查询所有成功", allOrder);
        }else {
            json = Util.convertJson(0, "查询所有失败");
        }
        writer.append(json);
    }

    // 结算订单 修改订单
    @RequestMapping("/pay")
    public void pay(HttpServletResponse response, int orderId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int pay = orderService.pay(orderId);
        if(pay > 0) {
            json = Util.convertJson(1, "结算成功");
        }else {
            json = Util.convertJson(0, "结算失败");
        }
        writer.append(json);
    }

    @RequestMapping("/cancelOrder")
    public void cancelOrder(HttpServletResponse response, int orderId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        String json = null;
        int pay = orderService.pay(orderId);
        if(pay > 0) {
            json = Util.convertJson(1, "取消成功");
        }else {
            json = Util.convertJson(0, "取消失败");
        }
        writer.append(json);
    }

    @RequestMapping("/test")
    public void test(HttpServletResponse response, int[] goodsId){
        String json = null;
        PrintWriter writer = Util.getWriter(response);
        System.out.println(Arrays.toString(goodsId));
        writer.append("sdjflsadfl");
    }

}
