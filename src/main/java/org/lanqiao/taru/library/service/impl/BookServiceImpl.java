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
    BookDao bookDaoImol;
    @Override
    public List<Book> queryList() {
        return bookDaoImol.queryList();
    }

    @Override
    public List<Book> queryByterm(String bookName, String bookAuthor) {
        return bookDaoImol.queryByterm(bookName,bookAuthor);
    }

    @Override
    public List queryBytop() {
        return bookDaoImol.queryBytop();
    }

    @Override
    public Book queryDetail(String bookId) {
        return bookDaoImol.queryDetail(bookId);
    }

    @Override
    public ArticleVo review(String articleBookId, String articleId) {
        return bookDaoImol.review(articleBookId, articleId);
    }
}
