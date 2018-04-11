package com.lanou.controller;

import com.lanou.entity.Order;
import com.lanou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaozhichao on 2018/4/4.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    // 添加订单
    public Map<String, Object> addOrder(Order order){
        int count = orderService.addOrder(order);
        Map<String, Object> map = new HashMap<String, Object>();


        return map;

    }
    // 取消订单
//    public Map<String, Object> removeOrder
}
