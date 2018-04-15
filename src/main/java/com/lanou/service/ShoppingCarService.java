package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.ShoppingCar;


import java.util.List;

/**
 * Created by lanou on 2018/4/3.
 */
public interface ShoppingCarService {

    public List<Goods> findOrderListByGoodsId(int goodsId);

    public int delete(ShoppingCar sc);

    public List<Goods> add(ShoppingCar shoppingCar);

//    public boolean isExistShop(ShoppingCar sc);
}
