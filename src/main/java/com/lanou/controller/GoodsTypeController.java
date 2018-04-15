package com.lanou.controller;

import com.lanou.entity.GoodsType;
import com.lanou.service.GoodsTypeService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2018/4/8.
 */
@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;
    @RequestMapping("/findGoodsType")
    public void findGoodsType(HttpServletResponse response){
        List<GoodsType> goodsType = goodsTypeService.findGoodsType();
        if (goodsType.size()!=0){
            Util.getWriter(response).append(Util.convertJson(goodsType,1));
        }else {
            Util.getWriter(response).append(Util.convertJson(goodsType,0));
        }
    }
    // 查询目录层次
    @RequestMapping("/findGoodsById")
    public void findGoodsById(int id, @RequestParam(defaultValue="0") int page,String goodsBrank, @RequestParam(defaultValue="0")float max,@RequestParam(defaultValue="0")float min ,HttpServletResponse response){
        String json = this.goodsTypeService.findTypeById01(id, page, goodsBrank, max, min);
        System.out.println("jhaajajsdasasdsaaaaaaaaaaa>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Util.getWriter(response).append(json);
    }

    // 按照价格排序降序
    @RequestMapping("/findGoodsOrderByPriceDesc")
    public void findGoodsOrderByPrice(int id, @RequestParam(defaultValue="0") int page,String goodsBrank, @RequestParam(defaultValue="0")float max,@RequestParam(defaultValue="0")float min ,HttpServletResponse response){
        String goodsOrderByPrice = goodsTypeService.findGoodsOrderByPrice(id, page, goodsBrank, max, min);
        Util.getWriter(response).append(goodsOrderByPrice);
    }
    @RequestMapping("/findGoodsOrderByPriceAsc")

    public void findGoodsOrderByPriceAsc(int id, @RequestParam(defaultValue="0") int page,String goodsBrank, @RequestParam(defaultValue="0")float max,@RequestParam(defaultValue="0")float min,HttpServletResponse response){
        String goodsOrderByPrice = goodsTypeService.findGoodsOrderByPriceAsc(id, page, goodsBrank, max, min);
        Util.getWriter(response).append(goodsOrderByPrice);
    }
}
