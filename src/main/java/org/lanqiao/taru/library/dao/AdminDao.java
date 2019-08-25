package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Book;

@Mapper
public interface AdminDao {
//    根据id查询图书详情
    public int  updateBookStatusBybookId (String bookId);
//修改根据id
    public int updateBookInfoBybookId( Book book);
//    添加数据
    public int insertIntoBooks(Book book);
}
