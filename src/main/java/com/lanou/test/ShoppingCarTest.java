package com.lanou.test;

import com.lanou.entity.ShoppingCar;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.lanou.impl.ShoppingCarServiceImpl;

/**
 * Created by gaozhichao on 2018/4/12.
 */
public class ShoppingCarTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        ShoppingCarServiceImpl goodsService = (ShoppingCarServiceImpl) applicationContext.getBean("shoppingCarService");
        goodsService.lala(1);
    }
    @Test
    public void test02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        ShoppingCarServiceImpl goodsService = (ShoppingCarServiceImpl) applicationContext.getBean("shoppingCarService");
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setGoodsId(3);
        shoppingCar.setUserId(1);
        int delete = goodsService.delete(shoppingCar);
        System.out.println(delete);
    }


}
