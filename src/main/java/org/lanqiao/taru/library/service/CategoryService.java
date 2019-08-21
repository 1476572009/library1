package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Category;

import java.util.List;

/*
 * Time:2019.8.20  17:16
 * 类别service接口
 *
 * */
public interface CategoryService {
     //查询父类别
     List<Category> getMainCategory();
     //查询子类别
     List<Category> getSonCategory(String categoryId);
}
