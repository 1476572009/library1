package org.lanqiao.taru.library.service;


import org.lanqiao.taru.library.model.Bookcar;

import java.util.List;

public interface BookcarService {
    public int insertBookcar(Bookcar bookcar);
    public int delBookcars(String[] bookcars);
    public int update(Bookcar bookcar);
    public List Bookcarlist(Bookcar booker);
}
