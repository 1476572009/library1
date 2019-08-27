package org.lanqiao.taru.library.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.service.OrderService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(description = "订单接口")
@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderApi {

    @Autowired
    OrderService os;
    JsonResult result=null;

    @ApiIgnore
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

    @ApiOperation(value="查询订单详情")
    @ApiImplicitParam(name = "orderUserId", value = "用户ID",paramType = "query",dataType = "String", required = true)
    @RequestMapping(value = "/query",method = RequestMethod.GET)
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

    @ApiOperation(value="查询订单详情")
    @ApiImplicitParam(name = "orderId", value = "用户ID",paramType = "query",dataType = "String", required = true)
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public JsonResult send(Order order){
        try {
            int i=os.send(order);

            if (i>0){
                result=new JsonResult("200","发货成功",i);
            }else {
                result =new JsonResult("400","发货失败",null);
            }

        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("400","异常",null);
        }
        return result;
    }

}
