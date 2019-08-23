package org.lanqiao.taru.library.api;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.User;
import org.lanqiao.taru.library.service.impl.UserServiceImpl;
import org.lanqiao.taru.library.util.IdUtil;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserApi {
    @Autowired
    UserServiceImpl impl;
    //    更新用户操作

    @RequestMapping("/api/user/login")
    public JsonResult userLogin(@Param("tele") String tele , @Param("password") String password){
        JsonResult jsonResult = null;
        try {
            User user = impl.Login(tele,password);
            if (tele.equals(user.getUserTelphone())&&password.equals(user.getUserPassword())){
                jsonResult = new JsonResult("200","登陆成功",user);
            }
        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("400","失败","");
        }
        return jsonResult;
    }
    @RequestMapping("/api/user/insert")
    public JsonResult Updateall(@Param("id") String id,
                                @Param("username") String username,
                                @Param("password") String password,
                                @RequestParam(value = "icon",defaultValue = "0") String icon,
                                @Param("address" ) String address,
                                @Param("telephone") String telephone,
                                @Param("email") String email,
                                @RequestParam(value = "grade",defaultValue = "0") String grade,
                                @Param("status") String status,
                                @Param("question") String question,
                                @Param("questions") String questions
    ){
        JsonResult jsonResult = null;
        try {
            String uid = IdUtil.getUuid();
            int a  = impl.userRegiste(uid,username,password,icon,address,email,telephone,grade,status,question,questions);
            jsonResult = new JsonResult("200","更新成功",a);
        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("400","失败","");
        }
        return jsonResult;

    }
    @RequestMapping("/api/user/sign")
    public JsonResult signg(@Param("id") String id){
        JsonResult jsonResult = null;
        try {
            int a  = impl.updateGra(id);

                jsonResult = new JsonResult("200","签到成功",a);

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("400","失败","");
        }
        return jsonResult;
    }
    @RequestMapping("/api/user/queryCollect")
    public JsonResult queryCollect(@Param("uid") String uid){
        JsonResult jsonResult = null;
        try {
            List<Book> book = impl.queryalll(uid);

            jsonResult = new JsonResult("200","签到成功",book);

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("400","失败","");
        }
        return jsonResult;
    }
    @RequestMapping("/api/user/insertCollect")
    public JsonResult insertCollect(@Param("collectid") String collectid, @Param("uid") String uid, @Param("bookid") String bookid, @Param("time") String time, @Param("status") String status){
        JsonResult jsonResult = null;
        try {
            String colid = IdUtil.getUuid();
            String times =  IdUtil.getDateId();
            int a = impl.insertColl(colid,uid,bookid,times,status);
            jsonResult = new JsonResult("200","插入成功",a);

        }catch (Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("400","失败","");
        }
        return jsonResult;
    }

}
