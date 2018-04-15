package com.lanou.service;

import com.lanou.entity.Address;
import com.lanou.entity.Goods;
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
    public Order buygoods(int userId);
    public Goods findAllGoods(int goodsId);
    public List<Address> findAllAddress(int userId);

    public int deleteOrder(int orderId);

    public List<Order> findAllOrder(int userId);
    public int pay(int orderId);
    public int cancelOrder(int orderId);
}
