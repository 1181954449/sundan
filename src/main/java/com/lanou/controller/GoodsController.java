package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/findGoodsByRecommend")
    public void findGoodsByRecommend(HttpServletResponse response) {
        PrintWriter writer = Util.getWriter(response);
        List<Goods> goodsByRecommend = goodsService.findGoodsByRecommend();
        writer.append(JSON.toJSONString(goodsByRecommend));
    }

    // 精品推荐
    @RequestMapping("/findGoodsByBoutique")
    public void findGoodsByBoutique(int id, HttpServletResponse response) {
        PrintWriter writer = Util.getWriter(response);
        writer.append(goodsService.findGoodsByBoutique(id));
    }
    @RequestMapping("/findGoodsByNew")
    public void findGoodsByNew(@RequestParam(defaultValue = "0") int page, HttpServletResponse response){
        PrintWriter writer = Util.getWriter(response);
        writer.append(goodsService.findGOodsByNew(page));
    }
}
