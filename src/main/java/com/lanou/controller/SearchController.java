package com.lanou.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;
import com.lanou.service.UserService;
import com.lanou.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private GoodsService goodsService;

    // 全局搜索
    @RequestMapping("/globalSearch")
    public void globalSearch(String keyWord,@RequestParam(defaultValue = "0")int page, HttpServletResponse response) {
        String json = goodsService.globalSearch(keyWord, page);
        Util.getWriter(response).append(json);
    }
    // 分页查询
    @RequestMapping("/findGoodsByPage")
    public void findGoodsByPage(int categoryId, @RequestParam(defaultValue = "0")int page, HttpServletResponse response) {
        String goodsByCategory = goodsService.findGoodsById(categoryId,page);
        Util.getWriter(response).append(goodsByCategory);
    }
}
