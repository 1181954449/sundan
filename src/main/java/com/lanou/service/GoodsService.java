package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.Goods_type;
import com.lanou.entity.goods_img;

import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2018/4/8.
 */
public interface GoodsService {
    //模糊查询搜索
    public String globalSearch(String keyWord,int page);
    // 类型查询
    public String findGoodsById(int category,int page);
    // 根据类型查询
    public String findGoodsByItemize(Map<String,Object> maps);
    // 首页推荐八个商品
    public List<Goods> findGoodsByRecommend();
<<<<<<< HEAD

    // 精品推荐商品
    public String findGoodsByBoutique(int id);

    // 新品查询
    public String findGOodsByNew(int page);
=======
    // 查询商品详情
    public Goods findgoodsdDetails(int goodsId);
    // 切换图片
    public List<goods_img> findgoodsCutImg(Goods_type goods_type);
>>>>>>> de05f203013ac4bca021422c88d338c03ecc53da
}
