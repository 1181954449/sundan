package com.lanou.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by gaozhichao on 2018/4/3.
 */
public class Order {
    // 订单id
    private int orderId;
    // 订单编号
    private String orderCoding;
    // 订单备注
    private String orderRemark;
    // 订单状态
    private String orderForm;
    // 订单是否被删除
    private String orderIsDelet;
    // 订单支付方式
    private String orderPay;
    // 订单实际金额
    private String orderPrice;
    // 订单的实际收货地址
    private int order_addressId;
    // 是否要发票
    private String orderIsInvoice;
    // 订单创建时间
    private String orderDate;
    // 订单商品
    private int order_goodsId;
    // 配送方式
    private String orderDistribution;
    // 用户Id
    private int user_id;
    // 商品数量
    private int goods_count;

    private List<Address> addresses;
    private List<Goods> goodss;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderCoding() {
        return orderCoding;
    }

    public void setOrderCoding() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHMMSS");
        Date date = new Date();
        String id = String.valueOf(order_goodsId);

        this.orderCoding = format.format(date) + id;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getOrderForm() {
        return orderForm;
    }

    public void setOrderForm(String orderForm) {
        this.orderForm = orderForm;
    }

    public String getOrderIsDelet() {
        return orderIsDelet;
    }

    public void setOrderIsDelet(String orderIsDelet) {
        this.orderIsDelet = orderIsDelet;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.orderDate = format.format(date);
    }

    public Order() {
        super();
    }

    public void setOrderIsInvoice(String orderIsInvoice) {
        this.orderIsInvoice = orderIsInvoice;
    }

    public String getOrderDistribution() {
        return orderDistribution;
    }

    public void setOrderDistribution(String orderDistribution) {
        this.orderDistribution = orderDistribution;
    }

    public int getOrder_addressId() {
        return order_addressId;
    }

    public void setOrder_addressId(int order_addressId) {
        this.order_addressId = order_addressId;
    }

    public String getOrderIsInvoice() {
        return orderIsInvoice;
    }

    public int getOrder_goodsId() {
        return order_goodsId;
    }

    public void setOrder_goodsId(int order_goodsId) {
        this.order_goodsId = order_goodsId;
    }

    public void setOrderCoding(String orderCoding) {
        this.orderCoding = orderCoding;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(List<Goods> goodss) {
        this.goodss = goodss;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderCoding='" + orderCoding + '\'' +
                ", orderRemark='" + orderRemark + '\'' +
                ", orderForm='" + orderForm + '\'' +
                ", orderIsDelet='" + orderIsDelet + '\'' +
                ", orderPay='" + orderPay + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", order_addressId=" + order_addressId +
                ", orderIsInvoice='" + orderIsInvoice + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", order_goodsId=" + order_goodsId +
                ", orderDistribution='" + orderDistribution + '\'' +
                ", user_id=" + user_id +
                ", goods_count=" + goods_count +
                ", addresses=" + addresses +
                ", goodss=" + goodss +
                '}';
    }
}
