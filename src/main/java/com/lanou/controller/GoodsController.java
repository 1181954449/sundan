package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
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

    @RequestMapping("/findGoodsByRecommend")
    public void findGoodsByRecommend(HttpServletResponse response){
        Util.crossomain(response);
        PrintWriter writer = Util.getWriter(response);
        List<Goods> goodsByRecommend = goodsService.findGoodsByRecommend();
        writer.append(JSON.toJSONString(goodsByRecommend));
    }
}
