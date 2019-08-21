package org.lanqiao.taru.library.api;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.taru.library.model.Category;
import org.lanqiao.taru.library.service.CategoryService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;

/*
* Time:2019.8.20  17:16
* 类别api接口
*
* */
@RestController
@CrossOrigin
public class CategoryApi {
    @Autowired
    CategoryService categoryService;
    //查询书籍类别ID
    @RequestMapping("/api/category/queryMain")
    public JsonResult queryMainCategory(){
        JsonResult jsonResult = null;
        try{
            List<Category> list =  categoryService.getMainCategory();
            jsonResult = new JsonResult("200","查询成功！",list);
            return jsonResult;
        }catch (Exception e){
            jsonResult = new JsonResult("500","查询失败！",e.getMessage());
            return jsonResult;
        }
    }
    //查询子类别跟据父类别ID
    @RequestMapping("/api/category/querySecond")
    public JsonResult querySoncategoryById(@Param("categoryId") String categoryId){
        JsonResult jsonResult = null;
        if (categoryId != null){
            try{
                List<Category> list = categoryService.getSonCategory(categoryId);
                jsonResult = new JsonResult("200","查询成功！",list);
                return jsonResult;
            }catch(Exception e) {
                jsonResult = new JsonResult("500","查询失败！",e.getMessage());
                return jsonResult;
            }
        }
        jsonResult = new JsonResult("404","未得到categoryId",null);
        return jsonResult;
    }
//    //根据子类别Id查询图书
//    public JsonResult queryBooksById(){
//
//    }

}
