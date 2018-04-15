package com.lanou.dao;

import com.lanou.entity.Order;

import java.util.List;

/**
 * Created by gaozhichao on 2018/4/4.
 */
public interface OrderDao {
    public int addOrder(Order order);
    // 删除订单
    public int deleteOrder(int orderId);
    // 查看所有订单
    public List<Order> findAllOrder(int userId);

    public int pay(int orderId);
    public int cancelOrder(int orderId);
}
