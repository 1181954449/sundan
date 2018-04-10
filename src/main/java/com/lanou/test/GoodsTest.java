package com.lanou.test;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
}
