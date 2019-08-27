package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.BookDao;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.model.Review;
import org.lanqiao.taru.library.service.BookService;
import org.lanqiao.taru.library.vo.ArticleVo;
import org.lanqiao.taru.library.vo.ReviewVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDaoImpl;
    @Override
    public List<Book> queryList() {
        return bookDaoImpl.queryList();
    }

    @Override
    public List<Book> queryByterm(String bookName, String bookAuthor) {
        return bookDaoImpl.queryByterm(bookName,bookAuthor);
    }

    @Override
    public List queryBytop() {
        return bookDaoImpl.queryBytop();
    }

    @Override
    public Book queryDetail(String bookId) {
        return bookDaoImpl.queryDetail(bookId);
    }

    @Override
    public ArticleVo review(String articleBookId, String articleId) {
        return bookDaoImpl.review(articleBookId, articleId);
    }

    @Override
    public List<Book> selectBooksLike(String bookName) {
        return bookDaoImpl.selectBooksLike(bookName);
    }

    @Override
    public List<Book> queryBookByCategroyId(String categroyId) {
        return bookDaoImpl.queryBookByCategroyId(categroyId);
    }

    @Override
    public List<ReviewVo> queryReview(String bookId) {
        return bookDaoImpl.queryReview(bookId);
    }

    @Override
    public boolean insertReview(Review review) {
        return bookDaoImpl.insertReview(review);
    }

    //    根据id删除订单（逻辑删除）
    @Override
    public int deleteOrderByOrderId(String orderId) {
        return bookDaoImpl.deleteOrderByOrderId(orderId);
    }
    //    根据订单查询订单详情
    @Override
    public Order queryOrderByOrderId(String orderId) {
        return bookDaoImpl.queryOrderByOrderId(orderId);
    }

    //    查询订单列表（带分页）
    @Override
    public List<Order> queryOrderList() {
        return bookDaoImpl.queryOrderList();
    }

}
