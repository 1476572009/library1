package org.lanqiao.taru.library.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Log;
import org.lanqiao.taru.library.model.User;

import java.util.List;

@Mapper
public interface UserDao {
    public User LLogin(String tele, String password);
    public int updateOne(String id, String username, String password, String icon, String address, String email, String telephone, String grade, String status);
    public int updategrade(String id);
    public User selectAll(String id);
    public List<Book> queryal(String uid);
    public int insertCol(String collectid, String uid, String bookid, String time, String status);
    public Log selectog(String id);
    public  int insertLog(String logid, String uid, String bookid, String startime, String status);
    public User forgetdeal(String id, String question, String questions);
    public int userRegister(String id, String username, String password, String icon, String address, String email, String telephone, String grade, String status, String question, String questions);
}
