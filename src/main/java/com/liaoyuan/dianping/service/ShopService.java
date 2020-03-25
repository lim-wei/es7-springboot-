package com.liaoyuan.dianping.service;

import com.liaoyuan.dianping.common.BusinessException;
import com.liaoyuan.dianping.model.ShopModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by limw on 2020/3/20.
 */
public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;

    ShopModel get(Integer id);

    List<ShopModel> selectAll();

    Integer countAllShop();

    // 推荐
    List<ShopModel> recommend(BigDecimal longitude,BigDecimal latitude);

    // 搜索
    List<ShopModel> search(BigDecimal longitude,BigDecimal latitude,String keyword,
                           Integer orderby,Integer categoryId,String tags);

    // 根据标签进行分组查找
    List<Map<String,Object>> searchGroupByTags(String keyword,Integer categoryId,String tags);
}
