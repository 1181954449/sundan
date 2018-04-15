package com.lanou.test;


import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsService;
import com.lanou.service.GoodsTypeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by lanou on 2018/4/8.
 */
public class GoodsTypeTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsTypeService goodsTypeService = (GoodsTypeService) applicationContext.getBean("goodsTypeService");
        List<GoodsType> goodsType = goodsTypeService.findGoodsType();
        System.out.println(goodsType);
    }
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        String goodsByCategory = goodsService.findGoodsById(3001,0);
        System.out.println(goodsByCategory);
    }
    @Test
    public void test03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        String phone = goodsService.globalSearch("手机", 0);
        System.out.println(phone);
    }
    @Test
    public void test05(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsService goodsService = (GoodsService) applicationContext.getBean("goodsService");
        Map<String,Object> map = new HashMap();
        map.put("category_goods",3018);
        map.put("begin",0);
        String goodsByItemize = goodsService.findGoodsByItemize(map);
        System.out.println(goodsByItemize);
    }

    @Test
    public void test06(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsTypeService goodsService = (GoodsTypeService) applicationContext.getBean("goodsTypeService");
        GoodsType typeById = goodsService.findTypeById(3018);
        System.out.println(typeById);
    }

    @Test
    public void test07(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsTypeService goodsService = (GoodsTypeService) applicationContext.getBean("goodsTypeService");
        String typeById01 = goodsService.findTypeById01(2005, 0, "华为", 0.0F, 0.0F);
        System.out.println(typeById01);
    }
    @Test
    public void test08()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsTypeService goodsService = (GoodsTypeService)applicationContext.getBean("goodsTypeService");
        String typeById01 = goodsService.findTypeById01(1002, 0, null, 0.0F, 0.0F);
        System.out.println(typeById01);
    }

    @Test
    public void test09()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        GoodsTypeService goodsService = (GoodsTypeService)applicationContext.getBean("goodsTypeService");
        String typeById01 = goodsService.findGoodsOrderByPriceAsc(2005, 0, null, 0.0F, 0.0F);
        System.out.println(typeById01);
    }

}