package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.OrderDao;
import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.service.OrderService;
import org.lanqiao.taru.library.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao od;

    public int add(Order order) {

        return od.add(order);
    }
    public List query(Order order){
        return od.query(order);
    }
    public int update(Order order){
        return od.update(order);
    }
    public int send(Order order){return od.send(order);};
}
