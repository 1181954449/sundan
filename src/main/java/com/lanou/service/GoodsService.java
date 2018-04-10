package com.lanou.service;

import com.lanou.entity.Goods;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
public interface GoodsService {
    //模糊查询搜索
    public String globalSearch(String keyWord,int page);
    // 类型查询
    public String findGoodsById(int category,int page);
    // 根据类型查询
    public String findGoodsByItemize(Map<String,Object> maps);
    // 首页推荐八个商品
    public List<Goods> findGoodsByRecommend();
}
