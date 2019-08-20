package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Bookcar;

import java.util.List;

@Mapper
public interface BookcarDao {
    public int insertBookcar(Bookcar bookcar);
    public int delBookcars(String[] bookcars);
    public int update(Bookcar bookcar);
    public List Bookcarlist(Bookcar bookcar);
}
