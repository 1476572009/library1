package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.CategoryDao;
import org.lanqiao.taru.library.model.Category;
import org.lanqiao.taru.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Time:2019.8.20  17:16
 * 类别service实现类
 *
 * */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryDao categoryDao;
    //查询父类别
    @Override
    public List<Category> getMainCategory() {
        return categoryDao.selectCategory();
    }
    //查询子类别实现
    @Override
    public List<Category> getSonCategory(String categoryId) {
        return categoryDao.selectCategorySon(categoryId);
    }
}
