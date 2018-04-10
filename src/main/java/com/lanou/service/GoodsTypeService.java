package com.lanou.service;

import com.lanou.entity.GoodsType;

import java.util.List;

/**
 * Created by lanou on 2018/4/8.
 */
public interface GoodsTypeService {
    public List<GoodsType> findGoodsType();

    public GoodsType findTypeById(int id);

    public String findTypeById01(int id, int page, String goodsBrank, float max, float min);
}
