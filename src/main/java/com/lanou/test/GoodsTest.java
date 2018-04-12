package com.lanou.test;

import com.alibaba.fastjson.JSON;
import com.lanou.controller.GoodsController;
import com.lanou.entity.Goods;
import com.lanou.entity.goods_img;
import com.lanou.impl.GoodsServiceImp;
import com.lanou.service.GoodsService;
import com.lanou.util.Util;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.entity.Goods_type;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/10.
 */
public class GoodsTest {
    @Test
    public void test01(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
//        List<Goods> goodsByRecommend = goodsService.findGoodsByRecommend();
//        System.out.println("商品推荐8个:" + JSON.toJSONString(goodsByRecommend));
    }

    @Test
    public void test02(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        GoodsServiceImp goodsService = (GoodsServiceImp) applicationContext.getBean("goodsService");
//        Goods_type goods_type = new Goods_type();
//        goods_type.setGoods_id(2);
//        goods_type.setGoodsvalue("亮黑");
//        int i = goodsService.findgoodsTypeNumber(goods_type);
//        System.out.print(i);
    }
    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        Goods goods = goodsService.findgoodsdDetails(2);
        System.out.println("方法被执行");
//        System.out.print(goods);
        String json = Util.creatJson(0, "商品详情页查询成功", goods);
    }


    @Test
    public void test04(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsServiceImp goodsService = (GoodsServiceImp) applicationContext.getBean("goodsService");
//        List<Map<String, String>> maps = goodsService.selectgoodsType(2);
//        System.out.println(maps);
//        String json = JSON.toJSONString(maps);
//        System.out.println(json);

    }
    @Test
    public void test05(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsServiceImp goodsService = (GoodsServiceImp) applicationContext.getBean("goodsService");
        goodsService.findgoodsType(2);
    }

    @Test
    public void test06(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsServiceImp goodsService = (GoodsServiceImp) applicationContext.getBean("goodsService");
        goodsService.findKindGoods(2);
    }

}
