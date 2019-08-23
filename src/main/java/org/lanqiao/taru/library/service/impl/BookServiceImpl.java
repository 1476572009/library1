package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.BookDao;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.service.BookService;
import org.lanqiao.taru.library.vo.ArticleVo;
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
}
