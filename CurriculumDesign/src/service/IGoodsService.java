package service;

import po.Goods;

import java.util.List;

public interface IGoodsService {
    /*
    * 查询所有商品
    * */
    List<Goods> queryAllGoods();

    Goods findGoodsById(int id);

    boolean updateGoodsNumber(int goodsId,int buyNumber);
}