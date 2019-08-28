package org.lanqiao.taru.library.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
//    修改用户信息
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
    //根据用户Id查询用户详情
    @RequestMapping("/api/user/queryByuserId")
    public JsonResult queryByuId(String userId){
        JsonResult jsonResult = null;
        try{
            if (userId != null){
                User user = impl.queryByUserId(userId);
                jsonResult = new JsonResult("200","查询成功",user);
            }else{
                jsonResult = new JsonResult("404","查询失败，未传入参数！",null);
            }
        }catch(Exception e){
            jsonResult = new JsonResult("500","查询失败",e.getMessage());
        }
        return jsonResult;
    }

//    根据用户id删除用户信息
    @RequestMapping("/api/user/deleteUserByUserId")
    public JsonResult deleteUserByUserId(String userId){
        JsonResult jsonResult = null;
        try{
            if (userId != null){
                int i=impl.deleteUserByUserId(userId);
                if(i>0){
                    jsonResult = new JsonResult("200","删除成功",i);
                }else{
                    jsonResult = new JsonResult("404","删除失败，未找到该用户",null);
                }

            }else{
                jsonResult = new JsonResult("404","查询失败，未传入参数！",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","删除异常",e.getMessage());
        }
        return jsonResult;
    }
//    查询用户列表信息
    @RequestMapping("/api/user/queryUserList")
    public JsonResult queryUserList(int pageSize,int pageNum){
        JsonResult jsonResult = null;
        try{
                PageHelper.startPage(pageSize,pageNum);
                List<User> users=impl.queryUserList();
                PageInfo<User> userPageInfo=new PageInfo<User>(users);
                if(users!=null){
                    jsonResult = new JsonResult("200","查询用户成功",users);
                }else{
                    jsonResult = new JsonResult("404","查询用户失败，暂无用户",null);
                }


        }catch(Exception e){
            e.printStackTrace();
            jsonResult = new JsonResult("500","查询用户异常",e.getMessage());
        }
        return jsonResult;
    }

}
