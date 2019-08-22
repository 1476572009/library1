package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Order;

import java.util.List;

public interface OrderService {
    public int add(Order order);
    public List query(Order order);
    public int update(Order order);
}
