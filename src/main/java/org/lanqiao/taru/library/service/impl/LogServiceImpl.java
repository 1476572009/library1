package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.LogDao;
import org.lanqiao.taru.library.model.Log;
import org.lanqiao.taru.library.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;
    //插入浏览信息
    @Override
    public int insertLog(Log log) {
        return logDao.insertLog(log);
    }
    //查询浏览信息
    @Override
    public List<Log> selectLog(String userId) {
        return logDao.selectLog(userId);
    }
}
