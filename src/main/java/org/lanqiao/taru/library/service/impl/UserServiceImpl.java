package org.lanqiao.taru.library.service.impl;

import org.lanqiao.taru.library.dao.UserDao;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Log;
import org.lanqiao.taru.library.model.User;
import org.lanqiao.taru.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public User Login(String tele, String password) {
        return userDao.LLogin(tele,password);
    }

    @Override
    public int updateAll(String id,String username, String password, String icon, String address, String email, String telephone, String grade, String status) {
        return userDao.updateOne(id,username,password,icon,address,email,telephone,grade,status);
    }

    @Override
    public int updateGra(String id) {
        return  userDao.updategrade(id);
    }

    @Override
    public User selectAl(String id) {
        return userDao.selectAll(id);
    }

    @Override
    public List<Book> queryalll(String uid) {
        return userDao.queryal(uid);
    }

    @Override
    public int insertColl(String collectid, String uid, String bookid, String time, String status) {
        return userDao.insertCol(collectid,uid,bookid,time,status);
    }

    @Override
    public Log selectLog(String id) {
        return userDao.selectog(id);
    }

    @Override
    public int insertLog(String logid, String uid, String bookid, String startime, String status) {
        return userDao.insertLog(logid,uid,bookid,startime,status);
    }

    @Override
    public User selpassword(String id, String question, String questions) {
        return userDao.forgetdeal(id,question,questions);
    }

    @Override
    public int userRegiste(String id, String username, String password, String icon, String address, String email, String telephone, String grade, String status, String question, String questions) {
        return userDao.userRegister(id,username,password,icon,address,email,telephone,grade,status,question,questions);
    }
    //根据用户Id详情查询用户详情
    @Override
    public User queryByUserId(String userId) {
        return userDao.queryUserByuserId(userId);
    }


}
