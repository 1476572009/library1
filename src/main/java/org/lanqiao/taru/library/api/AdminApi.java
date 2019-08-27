package org.lanqiao.taru.library.api;

import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.service.AdminService;
import org.lanqiao.taru.library.util.IdUtil;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin
public class AdminApi {
    @Autowired
    AdminService adminService;
    //    根据id查询图书详情
    @RequestMapping("/api/book/updateBookBybookId")
    @ResponseBody
    public JsonResult updateBookBybookId(String bookId){
        JsonResult jsonResult;
        try{
            int line=adminService.updateBookStatusBybookId(bookId);
            if(line>0){
                jsonResult=new JsonResult("200","删除成功",line);
            }else{
                jsonResult=new JsonResult("404","删除失败",line);
            }
        }catch (Exception e){
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return jsonResult;
    }

//    修改
    @RequestMapping("/api/book/updateBookInfoBybookId")
    @ResponseBody
    public JsonResult updateBookInfoBybookId(String bookId,String bookName,String bookAuthor, String bookCategoryId,
                                             String bookPrice,String bookStockSize,String bookComment){
        JsonResult jsonResult;
        Book book;

        try{
            book =new Book();
            book.setBookId(bookId);
            book.setBookName(bookName);
            book.setBookAuthor(bookAuthor);
            book.setBookCategoryId(bookCategoryId);
            book.setBookComment(bookComment);
            book.setBookPrice(bookPrice);
            book.setBookStockSize(bookStockSize);
            int line=adminService.updateBookInfoBybookId(book);
            if(line>0){
                jsonResult=new JsonResult("200","修改成功",line);
            }else{
                jsonResult=new JsonResult("404","修改失败",line);
            }
        }catch (Exception e){
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return jsonResult;
    }

//    添加图书
    @RequestMapping("/api/book/insertIntoBooks")
    @ResponseBody
public JsonResult insertIntoBooks(String bookName,String bookAuthor, String bookCategoryId,
                                  String bookPicture,String bookPrice,String bookStockSize,String bookComment){
    JsonResult jsonResult;
    Book book;

    try{
        book =new Book();
        book.setBookId(IdUtil.getUuid());
        book.setBookCode(IdUtil.getUuid());
        book.setBookPublishTime(IdUtil.getDateId());
        book.setBookName(bookName);
        book.setBookAuthor(bookAuthor);
        book.setBookCategoryId(bookCategoryId);
        book.setBookPicture(bookPicture);
        book.setBookComment(bookComment);
        book.setBookPrice(bookPrice);
        book.setBookStockSize(bookStockSize);
        int line=adminService.insertIntoBooks(book);

        if(line>0){
            jsonResult=new JsonResult("200","添加成功",line);
        }else{
            jsonResult=new JsonResult("404","添加失败",line);
        }
    }catch (Exception e){
        jsonResult=new JsonResult("500","添加异常",e.getMessage());
    }
    return jsonResult;
}
}
