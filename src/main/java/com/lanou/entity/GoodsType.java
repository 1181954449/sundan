package com.lanou.entity;

/**
 * Created by lanou on 2018/4/8.
 */
public class GoodsType {
    /**
     * 父级id
     * 自身id
     * 分类名称
     */
    private int parent_id;
    private int category_id;
    private String name;

    public GoodsType() {
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "parent_id=" + parent_id +
                ", category_id=" + category_id +
                ", name='" + name + '\'' +
                '}';
    }
}

