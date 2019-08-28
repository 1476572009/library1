package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Log;

import java.util.List;

@Mapper
public interface LogDao {
    //插入浏览记录
    public int insertLog(Log log);
    //查询浏览记录表
    public List<Log> selectLog(String userId);
}
