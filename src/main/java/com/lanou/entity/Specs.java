package com.lanou.entity;

/**
 * Created by lanou on 2018/4/9.
 */
public class Specs {
    private int specsId;
    private int categoryId;
    private String specsBrand;
    private int parentId;
    private int sunId;
    private float max;
    private float min;
    private String material;
    private String bind;
    private String color;
    private String type;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Specs() {

    }

    @Override
    public String toString() {
        return "Specs{" +
                "specsId=" + specsId +
                ", categoryId=" + categoryId +
                ", specsBrand='" + specsBrand + '\'' +
                ", parentId=" + parentId +
                ", sunId=" + sunId +
                ", max=" + max +
                ", min=" + min +
                ", material='" + material + '\'' +
                ", bind='" + bind + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public int getSpecsId() {
        return specsId;
    }

    public void setSpecsId(int specsId) {
        this.specsId = specsId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getSunId() {
        return sunId;
    }

    public void setSunId(int sunId) {
        this.sunId = sunId;
    }

    public String getSpecsBrand() {
        return specsBrand;
    }

    public void setSpecsBrand(String specsBrand) {
        this.specsBrand = specsBrand;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }



    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
