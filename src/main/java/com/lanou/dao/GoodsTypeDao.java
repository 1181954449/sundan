package com.lanou.dao;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lanou on 2018/4/8.
 */
@Repository
public interface GoodsTypeDao {
    public List<GoodsType> findGoodsType();

    public GoodsType findTypeById(int id);

    public List<GoodsType> findTypeById02(int parentId);
}
