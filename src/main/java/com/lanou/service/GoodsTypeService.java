package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
public interface GoodsTypeService {
    public List<GoodsType> findGoodsType();

    public GoodsType findTypeById(int id);

    public String findTypeById01(int id, int page, String goodsBrank, float max, float min);

    // 根据价格排序
    public String findGoodsOrderByPrice(int id, int page, String goodsBrank, float max, float min);
    // 按照价格升序
    public String findGoodsOrderByPriceAsc(int id, int page, String goodsBrank, float max, float min);
}
