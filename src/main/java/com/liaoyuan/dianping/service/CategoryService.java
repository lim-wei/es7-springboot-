package com.liaoyuan.dianping.service;

import com.liaoyuan.dianping.common.BusinessException;
import com.liaoyuan.dianping.model.CategoryModel;

import java.util.List;

/**
 * Created by limw on 2020/3/17.
 */
public interface CategoryService {

    CategoryModel create(CategoryModel categoryModel) throws BusinessException;

    CategoryModel get(Integer id);

    List<CategoryModel> selectAll();

    Integer countAllCategory();

}
