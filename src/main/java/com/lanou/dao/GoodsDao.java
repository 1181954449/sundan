package com.lanou.dao;

import com.lanou.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import com.lanou.entity.goods_img;
import com.lanou.entity.Goods_type;

/**
 * Created by lanou on 2018/4/8.
 */
@Repository
public interface GoodsDao {
    //模糊查询搜索
    public List<Goods> globalSearch(Map<String,Object> map);

    // 根据第几页查询商品
    public List<Goods> findGoodsById(Map<String,Object> map);

    // 查询一共多少页
    public int findGoodsByCategory(int categoryId);

    public int findGoodsPage(Map<String,Object> map);

    public List<Goods> findDimByGoods(Map<String,Object> map);
    // 根据类型查询一共多少条数据
    public int findGoodsByItemize(Map<String,Object> map);

    public List<Goods> findGoodsByPage(Map<String,Object> map);

    // 根据目录查找商品
    public List<Goods> findGoodsByContent(Map<String,Object> map);

    public abstract int findGoodsByContentPage(Map<String, Object> map);
    // 首页推荐八个商品
    public List<Goods> findGoodsByRecommend();

    // 商品详情页数据查询
    public Goods findgoodsdDetails(int goodsId);

    // 商品详情的图片
    public List<goods_img> findgoodsImg(int goodsId);

    // 商品规格
    public List<Goods_type> findgoodsType(int goodsId);

    // 切换图片请求
    public List<goods_img> findgoodsCutImg(Goods_type goods_type);
    // 获取不同颜色的图片编号
    public int findgoodsTypeNumber(Goods_type goods_type);
}
