package com.lanou.entity;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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
                '}';
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

    public Goods() {

        super();
    }

}
