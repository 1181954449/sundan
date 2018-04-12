package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2018/4/4.
 */
public class ShoppingCar {
    private int shoppingCarId;
    private int userId,goodsId;
    private int number;
    private List<Goods> goodsList;

    public int getShoppingCarId() {
        return shoppingCarId;
    }

    public void setShoppingCarId(int shoppingCarId) {
        this.shoppingCarId = shoppingCarId;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShoppingCar() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shoppingCarId=" + shoppingCarId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", number=" + number +
                ", goodsList=" + goodsList +
                '}';
    }
}
