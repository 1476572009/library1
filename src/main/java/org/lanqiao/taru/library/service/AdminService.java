package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Book;

public interface AdminService {

    //    根据id删除图书详情
    public int updateBookStatusBybookId(String bookId);
    //修改根据id
    public int updateBookInfoBybookId( Book book);
    //    添加数据
    public int insertIntoBooks(Book book);
}
