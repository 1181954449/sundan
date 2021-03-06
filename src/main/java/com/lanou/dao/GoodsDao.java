package com.lanou.dao;

import com.lanou.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    // 精品推荐商品
    public List<Goods> findGoodsByBoutique(Map<String, Object> map);
    // 查询一共多少条记录
    public int findGoodsByNewPage();

<<<<<<< HEAD


    // 商品详情页数据查询
    public Goods findgoodsdDetails(int goodsId);

    // 商品详情的图片
    public List<goods_img> findgoodsImg(int goodsId);

    // 商品规格
    public List<String> findgoodsType(int goodsId);

    // 商品规格
    public List<Map<String, String>> selectgoodsType(int goodsId);

    public Map<String, List<Map<String, String>>> selectgoodsSpec(int goodsId);

    public List<String> selectSpecTitle(int goodsId);
    public List<Integer> selectSpecId(int goodsId);
    public List<Map<String, String>> selectValue(int goodsId);

    // 查询此类商品的Id
    public int goodsProperty(int goodsId);
    // 同类商品推荐
    public List<Goods> goodsList(int propertyId);
    // 切换图片请求
    public List<goods_img> findgoodsCutImg(int typeNumber);
    // 获取不同颜色的图片编号
    public int findgoodsTypeNumber(Goods_type goods_type);
    // 根据goodsId获取goods
    public Goods selectGoodsList(int goodsId);
=======
    public List<Goods> findGoodsByNew(int page);
    // 根据价格排序
    public List<Goods> findGoodsOrderByPrice(Map<String, Object> map);
    // 按照价格升序
    public List<Goods> findGoodsOrderByPriceAsc(Map<String, Object> map);
>>>>>>> 4ab554c5249317ebf19a04c509e677ab85326ce9
}
