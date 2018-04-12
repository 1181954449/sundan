package com.lanou.entity;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
public class Goods {
    /**
     * ID
     * 标题
     * 价格
     * 商品第一张图
     * 是否热门
     */
    private int goodsId;
    private String goodsTitle;
    private String price;
    private String goodsFirstPic,isHot;
    private int category;
    private String goods_attrbute;
    private int goodsNumber;
    private List<goods_img> goods_imgs;
    private List<Goods_type> goods_types;
    private List<Map<String, String>> typeList;
    private Map<String, List<Map<String, String>>> specList;
    private List<Goods> goodss;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGoodsFirstPic() {
        return goodsFirstPic;
    }

    public void setGoodsFirstPic(String goodsFirstPic) {
        this.goodsFirstPic = goodsFirstPic;
    }

    public List<goods_img> getGoods_imgs() {
        return goods_imgs;
    }

    public void setGoods_imgs(List<goods_img> goods_imgs) {
        this.goods_imgs = goods_imgs;
    }

    public List<Goods_type> getGoods_types() {
        return goods_types;
    }

    public void setGoods_types(List<Goods_type> goods_types) {
        this.goods_types = goods_types;
    }

    public String getGoods_attrbute() {
        return goods_attrbute;
    }

    public void setGoods_attrbute(String goods_attrbute) {
        this.goods_attrbute = goods_attrbute;
    }

    public List<Map<String, String>> getTypeList() {return typeList;}

    public int getGoodsNumber() {return goodsNumber;}

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public void setTypeList(List<Map<String, String>> typeList) {
        this.typeList = typeList;
    }

    public Goods() {
        super();
    }

    public Map<String, List<Map<String, String>>> getSpecList() {
        return specList;
    }

    public void setSpecList(Map<String, List<Map<String, String>>> specList) {
        this.specList = specList;
    }

    public List<Goods> getGoodss() {
        return goodss;
    }

    public void setGoodss(List<Goods> goodss) {
        this.goodss = goodss;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", price='" + price + '\'' +
                ", goodsFirstPic='" + goodsFirstPic + '\'' +
                ", isHot='" + isHot + '\'' +
                ", category=" + category +
                ", goods_attrbute='" + goods_attrbute + '\'' +
                ", goods_imgs=" + goods_imgs +
                ", goods_types=" + goods_types +
                ", typeList=" + typeList +
                '}';
    }
}
