package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.BorrowDao;
import org.lanqiao.taru.library.model.Borrow;
import org.lanqiao.taru.library.service.BorrowService;
import org.lanqiao.taru.library.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    BorrowDao bd;

    public int insert(Borrow borrow){
        borrow.setBorrowId(IdUtil.getDateId());
        borrow.setBorrowRemaintime(borrow.getBorrowTime());
        return bd.insert(borrow);
    }

    public List query(Borrow borrow){

        return bd.query(borrow);
    }
}
