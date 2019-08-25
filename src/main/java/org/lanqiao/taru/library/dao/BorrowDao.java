package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.taru.library.model.Borrow;

import java.util.List;

@Mapper
public interface BorrowDao {
    public int insert(Borrow borrow);
    public List query(Borrow borrow);
    public int queryBookByUidandBookId(@Param("userId") String userId, @Param("bookId")String bookId);
}
