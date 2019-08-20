package org.lanqiao.taru.library.api;

import org.lanqiao.taru.library.model.Bookcar;
import org.lanqiao.taru.library.service.BookcarService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/bookcar")
public class BookcarApi {
    @Autowired
    BookcarService bs;
    JsonResult result=null;



    @RequestMapping("/insertBookcar")
    public JsonResult insertBookcar(Bookcar bookcar){
        try {
            int i=bs.insertBookcar(bookcar);

            if (i>0){
                result=new JsonResult("200","插入成功",i);
            }else {
                result =new JsonResult("400","插入失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","异常",null);
        }
        return result;
    }

    @RequestMapping("/delBookcars")
    public JsonResult delBookcars(String bookcars){
        String[] list=bookcars.split(",");
        System.out.println(list);
        try {
            int i=bs.delBookcars(list);
            if (i>0){
                result =new JsonResult("200","删除成功",i);
            }else {
                result =new JsonResult("400","删除失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("500","异常",e.getMessage());
        }
        return result;
    }
    @RequestMapping("/update")
    public JsonResult update(Bookcar bookcar){
        try {
            int i=bs.update(bookcar);
            if (i>0){
                result =new JsonResult("200","修改成功",i);
            }else {
                result =new JsonResult("400","修改失败",i);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","异常",null);
        }
        return result;
    }

    @RequestMapping("/Bookcarlist")
    public JsonResult Bookcarlist(Bookcar bookcar){
        try {
            List list=bs.Bookcarlist(bookcar);
            if (list.size()>0){
                result =new JsonResult("200","查询成功",list);
            }else {
                result =new JsonResult("400","查询失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","异常",null);
        }
        return result;
    }

}
