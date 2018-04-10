package com.lanou.impl;

import com.alibaba.fastjson.JSON;
import com.lanou.dao.GoodsDao;
import com.lanou.dao.GoodsTypeDao;
import com.lanou.dao.SpecsDao;
import com.lanou.entity.Goods;
import com.lanou.entity.GoodsType;
import com.lanou.entity.Specs;
import com.lanou.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
@Service("goodsTypeService")
public class GoodsTypeServiceImp implements GoodsTypeService{
    @Autowired
    private GoodsTypeDao goodsTypeDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private SpecsDao specsDao;
    @Override
    public List<GoodsType> findGoodsType() {
        return goodsTypeDao.findGoodsType();
    }

    @Override
    public GoodsType findTypeById(int id) {
        return goodsTypeDao.findTypeById(id);
    }

    @Override
    public String findTypeById01(int id, int page, String goodsBrank, float max, float min)
    {
        GoodsType typeById = this.goodsTypeDao.findTypeById(id);
        int parent_id = typeById.getParent_id();

        List<GoodsType> second = this.goodsTypeDao.findTypeById02(parent_id);

        List<GoodsType> lower = this.goodsTypeDao.findTypeById02(id);

        List<GoodsType> first = this.goodsTypeDao.findTypeById02(0);

        Map<String, Object> map = new HashMap();

        map.put("current directory", typeById);

        map.put("parent directory", second);

        map.put("substratum directory", lower);

        map.put("first", first);
        Map<String, Object> map1 = new HashMap();
        if ((id > 1000) && (id < 2000)) {
            map1.put("categoryid", Integer.valueOf(id));
        } else if ((id > 2000) && (id < 3000)) {
            map1.put("parentId", Integer.valueOf(id));
        } else {
            map1.put("sunId", Integer.valueOf(id));
        }
        map1.put("page", Integer.valueOf(page));
        if (goodsBrank != null) {
            map1.put("specsBrand", goodsBrank);
        }
        if ((max != 0.0F) && (min != 0.0F))
        {
            map1.put("max", Float.valueOf(max));
            map1.put("min", Float.valueOf(min));
        }
        int goodsByContentPage = this.goodsDao.findGoodsByContentPage(map1);
        map.put("goodsByContentPage", Integer.valueOf((int)Math.ceil(goodsByContentPage * 1.0D / 50.0D)));

        List<Goods> goodsByContents = this.goodsDao.findGoodsByContent(map1);
        System.out.println(goodsByContents);
        map.put("goods", goodsByContents);

        List<Specs> specsByContent = this.specsDao.findSpecsByContent(map1);
        map.put("allGoodsSpecs", specsByContent);
        String json = JSON.toJSONString(map);
        return json;
    }
}
