package org.lanqiao.taru.library.api;

import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.service.BookService;
import org.lanqiao.taru.library.vo.ArticleVo;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@CrossOrigin
public class BookApi {
    @Autowired
    BookService bookService;
//    查询图书列表
    @RequestMapping("/api/book/queryBooks")
    @ResponseBody
    public JsonResult queryList(){
        JsonResult jsonResult;
        try {
            List<Book> list=bookService.queryList();
            System.out.println("list.size="+list.size());
            if(list.size()>0){
                jsonResult=new JsonResult("200","查询成功", list);
            }else {
                jsonResult=new JsonResult("404","图书列表为空或当前页为空",list);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return  jsonResult;
    }

//    多条件查询

    /**
     *
     * @param bookName 书籍名称
     * @param bookAuthor 作者名
     * 二者随意结合
     * @return
     */
    @RequestMapping("/api/book/queryByterm")
    @ResponseBody
    public JsonResult queryList( String bookName, String bookAuthor){
        JsonResult jsonResult;
        try{
           List<Book> list=bookService.queryByterm(bookName,bookAuthor);
           if(list.size()>0){
               jsonResult=new JsonResult("200","查询成功",list);
           }else {
               jsonResult=new JsonResult("404","查询的图书不存在",null);
           }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return jsonResult;
    }
    /**
     * 查询榜单
     */
    @RequestMapping("/api/book/queryBytop")
    @ResponseBody
    public JsonResult queryBytop() {
        JsonResult jsonResult;
        try{
           List list= bookService.queryBytop();
           if(list.size()>0){
               jsonResult=new JsonResult("200","查询成功",list);
           }else {
               jsonResult=new JsonResult("404","查询失败，暂无榜单",list);
           }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return jsonResult;
    }
    //查询图书详情

    /**
     *
     * @param bookId 根据图书id查询图书的详情
     * @return
     */
    @RequestMapping("/api/book/queryDetail")
    @ResponseBody
    public JsonResult queryDetail(String bookId){
        JsonResult jsonResult;
        try{
            Book book=bookService.queryDetail(bookId);
            if(book!=null){
                jsonResult=new JsonResult("200","查询成功",book);
            }else{
                jsonResult=new JsonResult("404","查询失败，不存在此书籍",book);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","查询异常",e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 图书预览
     * @param articleBookId
     * @param articleId
     * @return
     */
    @RequestMapping("/api/book/review")
    @ResponseBody
    public JsonResult review(String articleBookId, String articleId ){
        JsonResult jsonResult;
        try{
           ArticleVo articleVo= bookService.review(articleBookId,articleId);
//
           if(articleVo!=null){
               jsonResult=new JsonResult("200","预览成功",articleVo);
           }else{
               jsonResult=new JsonResult("404","预览失败，此书籍或章节不存在",null);
           }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","预览异常",e.getMessage());
        }
        return jsonResult;
    }


    @RequestMapping("/api/book/selectBooksLike")
    @ResponseBody
    public JsonResult selectBooksLike(String bookName){
        JsonResult jsonResult;
        try{
            List<Book> list= bookService.selectBooksLike(bookName);
//
            if(list!=null){
                jsonResult=new JsonResult("200","预览成功",list);
            }else{
                jsonResult=new JsonResult("404","预览失败，此书籍或章节不存在",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","预览异常",e.getMessage());
        }
        return jsonResult;
    }
}
