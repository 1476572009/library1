package org.lanqiao.taru.library.service;


import org.lanqiao.taru.library.model.Log;

import java.util.List;

public interface LogService {

    //插入浏览信息
    public int insertLog( Log log);
    //查询浏览信息
    public List<Log>  selectLog(String userId);
}
