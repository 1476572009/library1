package org.lanqiao.taru.library.dao;


import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Order;

import java.util.List;

@Mapper
public interface OrderDao {
    public int add(Order order);
    public List query(Order order);
}
