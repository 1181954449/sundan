package com.lanou.Impl;

import com.lanou.dao.OrderDao;
import com.lanou.entity.Order;
import com.lanou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gaozhichao on 2018/4/4.
 */
@Service("orderService")
public class OrderSerciceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    public int addOrder(Order order) {
        order.setOrderCoding();
        order.setOrderDate();
        return orderDao.addOrder(order);
    }
}
