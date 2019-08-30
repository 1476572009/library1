package org.lanqiao.taru.library.api;

import org.lanqiao.taru.library.model.Log;
import org.lanqiao.taru.library.service.LogService;
import org.lanqiao.taru.library.util.IdUtil;
import org.lanqiao.taru.library.vo.JsonResult;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//浏览记录api
@RestController
@CrossOrigin
@RequestMapping("/api/log/")
public class LogApi {
    @Autowired
    LogService logService;
    //插入浏览记录
    @RequestMapping("/addLog")
    public JsonResult insertLog(String Log){
        JsonResult jsonResult = null;
        String[] logs = Log.split(",");
                if(logs.length==2){
                    try{
                        Log log = new Log();
                        log.setLogId(IdUtil.getUuid());
                        log.setLogBookId(logs[1]);
                        log.setLogUserId(logs[0]);
                        log.setLogStatus("1");
                       int i =  logService.insertLog(log);
                       jsonResult = new JsonResult("200","插入成功！","i");
                    }catch (Exception e){
                        jsonResult = new JsonResult("500","插入成功！",e.getMessage());
                    }
                }else{
                    jsonResult = new JsonResult("404","参数未传递！",null);
                }
                return jsonResult;
    }
    @RequestMapping("/queryLog")
    public JsonResult queryLog(String userId){
        JsonResult jsonResult = null;
        if (userId != null){
            try{
                List<Log> list = new ArrayList<Log>();
                list = logService.selectLog(userId);
                jsonResult = new JsonResult("200","查询成功！",list);
            }catch (Exception e){
                jsonResult = new JsonResult("500","查询失败！",null);
            }
        }else {
            jsonResult = new JsonResult("404","参数未传递！",null);
        }
        return jsonResult;
    }
}
