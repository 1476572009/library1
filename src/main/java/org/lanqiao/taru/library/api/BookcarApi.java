package org.lanqiao.taru.library.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.taru.library.model.Bookcar;
import org.lanqiao.taru.library.service.BookcarService;
import org.lanqiao.taru.library.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "书车接口")
@RestController
@CrossOrigin
@RequestMapping("/api/bookcar")
public class BookcarApi {
    @Autowired
    BookcarService bs;
    JsonResult result=null;


    @ApiOperation(value="添加书车")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "bookcarBookId", value = "图书ID",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "bookcarUserId", value = "用户ID",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "bookcarBorrowTime", value = "借书天数",paramType = "query",dataType = "String", required = true)})
    @RequestMapping(value = "/insertBookcar",method = RequestMethod.POST)
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

    @ApiOperation(value="删除书车",notes = "bookcarId用逗号拼接 可批量删除")
    @ApiImplicitParam(name = "bookcars", value = "书车ID，多个id用','拼接",paramType = "query",dataType = "String", required = true)
    @RequestMapping(value = "/delBookcars",method = RequestMethod.POST)
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
    @ApiOperation(value="修改书车借阅时间")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "bookcarId", value = "书车ID",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "bookcarBorrowTime", value = "借书天数",paramType = "query",dataType = "String", required = true)})
    @RequestMapping(value = "/update",method = RequestMethod.POST)
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

    @ApiOperation(value="查询用户所有书车")
    @ApiImplicitParam(name = "bookcarUserId", value = "用户ID",paramType = "query",dataType = "String", required = true)
    @RequestMapping(value = "/Bookcarlist",method = RequestMethod.POST)
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
