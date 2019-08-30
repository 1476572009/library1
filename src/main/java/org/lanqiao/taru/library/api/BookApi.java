package org.lanqiao.taru.library.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.model.Review;
import org.lanqiao.taru.library.service.BookService;
import org.lanqiao.taru.library.util.IdUtil;
import org.lanqiao.taru.library.vo.ArticleVo;
import org.lanqiao.taru.library.vo.JsonResult;
import org.lanqiao.taru.library.vo.OrderBookVo;
import org.lanqiao.taru.library.vo.ReviewVo;
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
//    queryBookByCategroyId
    @RequestMapping("/api/book/queryBookByCategroyId")
    public JsonResult queryBookByCategroyId(String categroyId){
        JsonResult jsonResult;
        try{
            List<Book> list= bookService.queryBookByCategroyId(categroyId);
            System.out.println(list.size());
            if(list!=null){
//                System.out.println(list.get(0).getBookId());
                jsonResult=new JsonResult("200","预览成功",list);
            }else{
                jsonResult=new JsonResult("404","预览失败，暂无此类别书籍",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","预览异常",e.getMessage());
        }
        return jsonResult;
    }

//查询评论
    @RequestMapping("/api/review/queryReview")
    @ResponseBody
    public JsonResult queryReview(String bookId) {
        JsonResult jsonResult;
        try{
            List<ReviewVo> list= bookService.queryReview(bookId);
            System.out.println(list.size());
            if(list!=null){
                jsonResult=new JsonResult("200","查看成功",list);
            }else{
                jsonResult=new JsonResult("404","查看失败，暂无此类别书籍",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","查看异常",e.getMessage());
        }
        return jsonResult;
    }
//    添加评论
    @RequestMapping("/api/review/insertReview")
    @ResponseBody
    public JsonResult insertReview(String reviewUserId,String reviewBookId,String reviewComment,String reviewFatherId){
        JsonResult jsonResult;
        Review review;
        try{
            review=new Review();
            review.setReviewId(IdUtil.getUuid());
            review.setReviewUserId(reviewUserId);
            review.setReviewBookId(reviewBookId);
            review.setReviewComment(reviewComment);
            review.setReviewFatherId(reviewFatherId);
            review.setReviewStatus("1");
            boolean isTrue= bookService.insertReview(review);
            if(isTrue){
                jsonResult=new JsonResult("200","评论成功",isTrue);
            }else{
                jsonResult=new JsonResult("404","评论失败",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult=new JsonResult("500","评论异常",e.getMessage());
        }
        return jsonResult;
    }


    //    根据id删除订单（逻辑删除）
    @RequestMapping("/api/order/deleteOrderByOrderId")
    @ResponseBody
    public JsonResult deleteOrderByOrderId(String orderId) {
        JsonResult jsonResult = null;
        try {
            int i=bookService.deleteOrderByOrderId(orderId);
            if(i>0){
                jsonResult = new JsonResult("200", "删除订单成功", i);
            }else{
                jsonResult = new JsonResult("404", "删除订单失败，该订单已被删除", i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult("400", "失败", e.getMessage());
        }
        return jsonResult;
    }
    //    根据订单id查询订单详情
    @RequestMapping("/api/order/queryOrderByOrderId")
    @ResponseBody
    public JsonResult queryOrderByOrderId(String orderId) {
        JsonResult jsonResult = null;
        try {
            OrderBookVo order=bookService.queryOrderByOrderId(orderId);
            if(order!=null){
                jsonResult = new JsonResult("200", "查询订单成功", order);
            }else{
                jsonResult = new JsonResult("404", "查询订单失败，该订单已被删除", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult("500", "查询订单异常", e.getMessage());
        }
        return jsonResult;
    }

    //    查询订单列表（带分页）
    @RequestMapping("/api/order/queryOrderList")
    @ResponseBody
    public JsonResult queryOrderList(int pageNum,int pageSize) {
        JsonResult jsonResult = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<Order> orders=bookService.queryOrderList();
            PageInfo<Order> page = new PageInfo<Order>(orders);
            if(orders.size()>0){
                jsonResult = new JsonResult("200", "查询订单列表成功", page);
            }else{
                jsonResult = new JsonResult("404", "查询订单列表失败，该订单已被删除", orders);
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult = new JsonResult("500", "查询订单列表异常", e.getMessage());
        }
        return jsonResult;
    }
    @RequestMapping("/api/order/delAll")
    public JsonResult delAll(String orderId){
        JsonResult jsonResult = null;
        String [] orderids = null;
        if (orderId!=null && orderId != "") {
            if (orderId.indexOf(",") != -1) {
                orderids = orderId.split(",");
            } else {
                orderids = new String[]{orderId};
            }
            try{
                int i = bookService.delAll(orderids);
               jsonResult =new JsonResult("200","删除成功！",i);
            }catch (Exception e){
                e.getMessage();
                jsonResult =new JsonResult("500","删除失败！",null);
            }

        }
        else {
            jsonResult = new JsonResult("404", "未传递参数！", null);
        }
        return jsonResult;
    }
}
