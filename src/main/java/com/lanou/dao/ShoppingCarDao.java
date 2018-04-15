package com.lanou.dao;

import com.lanou.entity.Goods;
import com.lanou.entity.ShoppingCar;


import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */
public interface ShoppingCarDao {
    //添加商品到购物车  通过userId 和 goodsId
    public int addShoppingCar(ShoppingCar shoppingCar);
    //通过userid获的所有商品信息
    public List<Goods> findGoodsList(int userId);
    //删除购物车的商品 通过userId 和 goodsId
    public int deleteShop(ShoppingCar sc);
}
