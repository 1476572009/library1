package org.lanqiao.taru.library.service.impl;


import org.lanqiao.taru.library.dao.AdminDao;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public int updateBookStatusBybookId(String bookId) {
        return adminDao.updateBookStatusBybookId(bookId);
    }

    @Override
    public int updateBookInfoBybookId(Book book) {
        return adminDao.updateBookInfoBybookId(book);
    }

    @Override
    public int insertIntoBooks(Book book) {

        return adminDao.insertIntoBooks( book);
    }
}
