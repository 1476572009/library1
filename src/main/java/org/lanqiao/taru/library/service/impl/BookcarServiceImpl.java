package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.BookcarDao;
import org.lanqiao.taru.library.model.Bookcar;
import org.lanqiao.taru.library.service.BookcarService;
import org.lanqiao.taru.library.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookcarServiceImpl implements BookcarService {
    @Autowired
    BookcarDao bd;

    public int insertBookcar(Bookcar bookcar) {
        bookcar.setBookcarId(IdUtil.getDateId());
        return bd.insertBookcar(bookcar);
    }
    public int delBookcars(String[] bookcars){

        return bd.delBookcars(bookcars);
    }
    public int update(Bookcar bookcar){
        return bd.update(bookcar);
    }
    public List Bookcarlist(Bookcar bookcar){
        return bd.Bookcarlist(bookcar);
    }
    //修改用户购书车书籍状态根据Id
    public int updateByCarId(String bookCarId){
        return bd.updateByCarId(bookCarId);
    }
}
