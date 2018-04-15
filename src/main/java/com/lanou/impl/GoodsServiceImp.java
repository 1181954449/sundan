package com.lanou.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.lanou.dao.GoodsDao;
import com.lanou.entity.Goods;
import com.lanou.entity.Goods_type;
import com.lanou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.entity.goods_img;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
@Service("goodsService")
public class GoodsServiceImp implements GoodsService{
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public String globalSearch(String keyWord,int page) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("dim",keyWord);
        int count = goodsDao.findGoodsPage(maps);
        // 向上取整获取页码
        int pageAll = (int) Math.ceil(count * 1.0 / 50);
        Map<String,Object> parm = new HashMap<>();
        parm.put("dim",keyWord);
        parm.put("page",page*50);
        List<Goods> dimByGoods = goodsDao.findDimByGoods(parm);
        Map<String,Object> converJson = new HashMap<>();
        converJson.put("page",pageAll);
        converJson.put("goodss",dimByGoods);
        String json = JSON.toJSONString(converJson);
        return json;
    }

    @Override
    public String findGoodsById(int category,int page) {
        // 查询一共有多少个商品
        int count = goodsDao.findGoodsByCategory(category);
        // 向上取整获取页码
        int pageAll = (int) Math.ceil(count * 1.0 / 50);
        // 将需要的商品编号和商品页码存入集合中
        Map<String ,Object> parm = new HashMap<>();
        parm.put("category",category);
        parm.put("page",page*50);
        // 调用dao层方法将所属该页面的商品集合查找出来
        List<Goods> goodss = goodsDao.findGoodsById(parm);
        // 创建集合
        Map<String, Object> map = new HashMap();
        // 添加所有页码
        map.put("page",pageAll);
        // 添加该页码的商品
        map.put("goodss",goodss);
        // 转换为json字符串
        String json = JSON.toJSONString(map);
        return json;
    }

    @Override
    public String findGoodsByItemize(Map<String, Object> maps) {
        int goodsByItemize = goodsDao.findGoodsByItemize(maps);
        System.out.println(goodsByItemize);
        String json = null;
        if (goodsByItemize!=0){
            int ceil = (int) Math.ceil(goodsByItemize * 1.0 / 50);
            List<Goods> goodss = goodsDao.findGoodsByPage(maps);
            Map<String,Object> convertMap = new HashMap<>();
            convertMap.put("page",ceil);
            convertMap.put("goodsInfo",goodss);
            json = JSON.toJSONString(convertMap);
        }
        return json;
    }

    @Override
    public List<Goods> findGoodsByRecommend() {
        return goodsDao.findGoodsByRecommend();
    }

    @Override
    public String findGoodsByBoutique(int id) {
        Map<String, Object> map1 = new HashMap();
        if ((id > 1000) && (id < 2000)) {
            map1.put("categoryid", Integer.valueOf(id));
        } else if ((id > 2000) && (id < 3000)) {
            map1.put("parentId", Integer.valueOf(id));
        } else {
            map1.put("sunId", Integer.valueOf(id));
        }
        List<Goods> goodsByBoutique = goodsDao.findGoodsByBoutique(map1);
        String json = JSON.toJSONString(goodsByBoutique);
        return json;
    }

    @Override
    public String findGOodsByNew(int page) {
        int goodsByNewPage = goodsDao.findGoodsByNewPage();
        goodsByNewPage  = (int )Math.ceil(goodsByNewPage * 1.0 / 9);
        List<Goods> goodsByNew = goodsDao.findGoodsByNew(page);
        Map<String ,Object> map = new HashMap<>();
        map.put("page",goodsByNewPage);
        map.put("goodss",goodsByNew);
        return JSON.toJSONString(map);
    }


    @Override
    public Goods findgoodsdDetails(int goodsId) {
        Goods goods = goodsDao.findgoodsdDetails(goodsId);
        List<goods_img> imgList = goodsDao.findgoodsImg(goodsId);
        List<Map<String, String>> map = goodsDao.selectgoodsType(goodsId);

        Map<String, List<Map<String, String>>> list = new HashMap<>();
        List<String> strings = goodsDao.selectSpecTitle(goodsId);
        System.out.println(strings);
        List<Integer> ints = goodsDao.selectSpecId(goodsId);
        System.out.println(ints);
        for (int i = 0; i < ints.size(); i++){

            List<Map<String, String>> maps = goodsDao.selectValue(ints.get(i));
            System.out.println(maps);
            list.put(strings.get(i), maps);
        }
        System.out.println(list);

        List<Goods> kindGoods = findKindGoods(goodsId);

        // 塞值
        goods.setGoods_imgs(imgList);
        goods.setTypeList(map);
        goods.setSpecList(list);
        goods.setGoodss(kindGoods);
        return goods;
    }

    @Override
    public List<goods_img> findgoodsCutImg(Goods_type goods_type) {
        int typeNumber = goodsDao.findgoodsTypeNumber(goods_type);
        System.out.print(typeNumber);
        List<goods_img> imgList = goodsDao.findgoodsCutImg(typeNumber);
        return imgList;
    }



    public List<Goods> findKindGoods(int goodsId){
        int propertyId = goodsDao.goodsProperty(goodsId);
        System.out.println(propertyId);
        List<Goods> goodss = goodsDao.goodsList(propertyId);
        System.out.println(goodss);
        System.out.println(goodss.size());
        return goodss;
    }

    public void findgoodsType(int goodsId){
        Map<String, List<Map<String, String>>> list = new HashMap<>();
        List<String> strings = goodsDao.selectSpecTitle(goodsId);
        System.out.println(strings);
        List<Integer> ints = goodsDao.selectSpecId(goodsId);
        System.out.println(ints);
        for (int i = 0; i < ints.size(); i++){

            List<Map<String, String>> maps = goodsDao.selectValue(ints.get(i));
            System.out.println(maps);
            list.put(strings.get(i), maps);
        }
        System.out.println(list);
        String s = JSON.toJSONString(list);
        System.out.println(s);
    }


}
