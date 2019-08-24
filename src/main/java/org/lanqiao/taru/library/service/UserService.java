package org.lanqiao.taru.library.service;

import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Log;
import org.lanqiao.taru.library.model.User;

import java.util.List;

public interface UserService {
    public User Login(String tele, String password);
    public int updateAll(String id, String username, String password, String icon, String address, String email, String telephone, String grade, String status);
    public int updateGra(String id);
    public User selectAl(String id);
    public List<Book> queryalll(String uid);
    public int insertColl(String collectid, String uid, String bookid, String time, String status);
    public Log selectLog(String id);
    public  int insertLog(String logid, String uid, String bookid, String startime, String status);
    public User selpassword(String id, String question, String questions);
    public int userRegiste(String id, String username, String password, String icon, String address, String email, String telephone, String grade, String status, String question, String questions);
    //查询用户详情根据用户Id
    public User queryByUserId(String userId);
}
