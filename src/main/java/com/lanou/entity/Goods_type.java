package com.lanou.entity;

/**
 * Created by gaozhichao on 2018/4/10.
 */
public class Goods_type {
    private int goods_typeId;
    private String goodskey;
    private String goodsvalue;
    private int goods_id;
    private int goods_type_number;

    public int getGoods_typeId() {
        return goods_typeId;
    }

    public void setGoods_typeId(int goods_typeId) {
        this.goods_typeId = goods_typeId;
    }

    public String getGoodskey() {
        return goodskey;
    }

    public void setGoodskey(String goodskey) {
        this.goodskey = goodskey;
    }

    public String getGoodsvalue() {
        return goodsvalue;
    }

    public void setGoodsvalue(String goodsvalue) {
        this.goodsvalue = goodsvalue;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_type_number() {
        return goods_type_number;
    }

    public void setGoods_type_number(int goods_type_number) {
        this.goods_type_number = goods_type_number;
    }

    public Goods_type() {
        super();
    }

    @Override
    public String toString() {
        return "Goods_type{" +
                "goods_typeId=" + goods_typeId +
                ", goodskey='" + goodskey + '\'' +
                ", goodsvalue='" + goodsvalue + '\'' +
                ", goods_id='" + goods_id + '\'' +
                ", goods_type_number=" + goods_type_number +
                '}';
    }
}
