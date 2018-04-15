package com.lanou.impl;

import ch.qos.logback.core.joran.action.ActionConst;
import com.lanou.dao.ShoppingCarDao;
import com.lanou.entity.Goods;
import com.lanou.entity.Order;
import com.lanou.entity.ShoppingCar;
import com.lanou.entity.User;
import com.lanou.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */
@Service("shoppingCarService")
public class ShoppingCarServiceImpl implements  ShoppingCarService{
    @Autowired
    private ShoppingCarDao shoppingCarDao;

    public List<Goods> findOrderListByGoodsId(int goodsId){

        return  shoppingCarDao.findGoodsList(goodsId);
    }

    public int delete(ShoppingCar sc){
        return  shoppingCarDao.deleteShop(sc);
    }

    @Override
    public List<Goods> add(ShoppingCar shoppingCar) {
        int count = shoppingCarDao.addShoppingCar(shoppingCar);
        List<Goods> goodsList = shoppingCarDao.findGoodsList(shoppingCar.getUserId());
        return goodsList;
    }

    public void lala(int userId){
        List<Goods> goodsList = shoppingCarDao.findGoodsList(userId);
        System.out.println(goodsList);
    }
}
