package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Borrow;

import java.util.List;

public interface BorrowService {
    public int insert(Borrow borrow);
    public List query(Borrow borrow);

}