package com.lanou.entity;

/**
 * Created by gaozhichao on 2018/4/10.
 */
public class goods_img {
    private int goodsImgId;
    private String goodsImg;
    private int goods_id;
    private String goods_details;
    private int goods_type_number;

    public int getGoodsImgId() {
        return goodsImgId;
    }

    public void setGoodsImgId(int goodsImgId) {
        this.goodsImgId = goodsImgId;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_details() {
        return goods_details;
    }

    public void setGoods_details(String goods_details) {
        this.goods_details = goods_details;
    }

    public int getGoods_type_number() {
        return goods_type_number;
    }

    public void setGoods_type_number(int goods_type_number) {
        this.goods_type_number = goods_type_number;
    }

    public goods_img() {
        super();
    }

    @Override
    public String toString() {
        return "goods_img{" +
                "goodsImgId=" + goodsImgId +
                ", goodsImg='" + goodsImg + '\'' +
                ", goods_id=" + goods_id +
                ", goods_details='" + goods_details + '\'' +
                ", goods_type_number=" + goods_type_number +
                '}';
    }
}
