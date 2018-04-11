package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.entity.Goods_type;
import com.lanou.entity.goods_img;
import com.lanou.service.GoodsService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lanou on 2018/4/10.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    // 推荐  前八个商品
    @RequestMapping("/findGoodsByRecommend")
    public void findGoodsByRecommend(HttpServletResponse response){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        List<Goods> goodsByRecommend = goodsService.findGoodsByRecommend();
        writer.append(JSON.toJSONString(goodsByRecommend));
    }

    // 商品详情
    @RequestMapping("/goodsdetails")
    public void findgoodsdDetails(HttpServletResponse response, int goodsId){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        Goods goods = goodsService.findgoodsdDetails(goodsId);
        System.out.println("方法被执行");
//        System.out.print(goods);
        String json = Util.creatJson(0, "商品详情页查询成功", goods);
        writer.append(json);
    }

    // 商品详情切换图片
    @RequestMapping("/goodsCutImg")
    public void findgoodsCutImg(Goods_type goods_type,  HttpServletResponse response){
        System.out.println(">>>>>>>>>>>>>>>"+goods_type);
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        List<goods_img> imgList = goodsService.findgoodsCutImg(goods_type);
        String json = Util.creatJson(0, "图片切换查询成功", imgList);
        writer.append(json);
    }
}
