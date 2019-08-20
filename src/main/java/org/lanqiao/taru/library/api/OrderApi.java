package org.lanqiao.taru.library.api;

import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.service.OrderService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderApi {

    @Autowired
    OrderService os;
    JsonResult result=null;

    @RequestMapping("/add")
    public JsonResult add(Order order){
        try {
            int i=os.add(order);

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
    @RequestMapping("/query")
    public JsonResult query(Order order){
        try {
            List list=os.query(order);

            if (list.size()>0){
                result=new JsonResult("200","查询成功",list);
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
