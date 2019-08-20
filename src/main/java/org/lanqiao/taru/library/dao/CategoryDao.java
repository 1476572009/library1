package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Category;

import java.util.List;

/*
* time：2019.8.20  17:20
* 书籍类别管理
*
* */
@Mapper
public interface CategoryDao {
    //查询所有父类别
    List<Category> selectCategory();
    //查询二级类别
    List<Category> selectCategorySon(String categoryId);
}
