package com.lanou.Impl;

import com.lanou.dao.GoodsDao;
import com.lanou.dao.OrderDao;
import com.lanou.dao.AddressDao;
import com.lanou.entity.Address;
import com.lanou.entity.Goods;
import com.lanou.entity.Order;
import com.lanou.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by gaozhichao on 2018/4/4.
 */
@Service("orderService")
public class OrderSerciceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private GoodsDao goodsDao;


    public int addOrder(Order order) {
        order.setOrderForm("生成订单");
        order.setOrderCoding();
        order.setOrderDate();
        int count = orderDao.addOrder(order);
        if(count>0){
//            Address address = addressDao.selectOrderAddress(order.getOrderId());
        }
        return count;
    }

    // 点击购买
    @Override
    public Order buygoods(int userId) {
        Order order = new Order();
        List<Address> addresses = addressDao.lookAddress(userId);
        order.setAddresses(addresses);
        return order;
    }

    public Goods findAllGoods(int goodsId){
        Goods goods = goodsDao.selectGoodsList(goodsId);
        return goods;
    }

    @Override
    public List<Address> findAllAddress(int userId) {
        List<Address> addresses = addressDao.lookAddress(userId);
        return addresses;
    }

    @Override
    public int deleteOrder(int orderId) {
        return orderDao.deleteOrder(orderId);
    }

    @Override
    public List<Order> findAllOrder(int userId) {
        List<Order> allOrder = orderDao.findAllOrder(userId);
        System.out.println(allOrder);
        return allOrder;
    }

    @Override
    public int pay(int orderId) {
        return orderDao.pay(orderId);
    }

    @Override
    public int cancelOrder(int orderId) {
        return orderDao.cancelOrder(orderId);
    }
}
