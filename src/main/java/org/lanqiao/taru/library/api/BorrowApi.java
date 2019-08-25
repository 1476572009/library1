package org.lanqiao.taru.library.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.taru.library.model.Borrow;
import org.lanqiao.taru.library.service.BorrowService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/borrow")
@Api(description = "订单详情接口")
public class BorrowApi {
    @Autowired
    BorrowService bs;
    JsonResult result=null;

    @ApiIgnore
    @RequestMapping("/insert")
    public JsonResult insert(Borrow borrow){
        try {
            int i=bs.insert(borrow);

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
    @ApiImplicitParam(name = "borrowOrderId", value = "订单ID",paramType = "query",dataType = "String", required = true)
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public JsonResult query(Borrow borrow){
        try {
            List list=bs.query(borrow);

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