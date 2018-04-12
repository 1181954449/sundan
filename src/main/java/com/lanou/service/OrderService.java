package com.lanou.service;

import com.lanou.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by gaozhichao on 2018/4/4.
 */
public interface OrderService {
    // 生称订单
    public int addOrder(Order order);

    // 点击购买
//    public Map<String, List<Object>> buygoods();
}
