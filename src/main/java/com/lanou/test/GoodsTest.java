package com.lanou.test;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.entity.goods_img;
import com.lanou.impl.GoodsServiceImp;
import com.lanou.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.entity.Goods_type;
import java.util.List;

/**
 * Created by lanou on 2018/4/10.
 */
public class GoodsTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        List<Goods> goodsByRecommend = goodsService.findGoodsByRecommend();
        System.out.println("商品推荐8个:" + JSON.toJSONString(goodsByRecommend));
    }

//    @Test
//    public void test02(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
//        GoodsService goodsService = (GoodsServiceImp) applicationContext.getBean("goodsService");
//        Goods_type goods_type = new Goods_type();
//        goods_type.setGoods_id(2);
//        goods_type.setGoodsvalue("亮黑");
//        List<goods_img> goods_imgs = goodsService.findgoodsCutImg(goods_type);
//        System.out.print(goods_imgs);
//    }
}
