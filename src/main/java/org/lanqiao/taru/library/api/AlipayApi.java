package org.lanqiao.taru.library.api;



import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.lanqiao.taru.library.config.AlipayConfig;
import org.lanqiao.taru.library.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RestController
@CrossOrigin
@Api(description = "支付宝支付接口")
public class AlipayApi {
    @Autowired
    AlipayService as;

    @ApiOperation(value="支付",notes="生成订单，删除选中的购物车项")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userId", value = "用户ID",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "bookcars", value = "书车ID，多条用','合并",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "total_amount", value = "总价格",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "subject", value = "订单标题",paramType = "query",dataType = "String", required = true),
            @ApiImplicitParam(name = "body", value = "订单备注", paramType = "query", dataType = "String", required = false)})
    @RequestMapping(value = "alipaySum")
    public String alipayIumpSum(String userId,String bookcars,String total_amount,String subject,String body,HttpServletResponse response, HttpServletRequest request) throws Exception {
        String[] list=bookcars.split(",");



            String result=as.alipayIumpSum(userId,list,total_amount,subject,body);
        return result;
    }

    @ApiIgnore
    @RequestMapping("notify_url")
    public void Notify(HttpServletRequest request) throws Exception {
        as.Notify(request);

    }

    @ApiIgnore
    @RequestMapping("return_url")
    public void Return_url(HttpServletRequest request) throws InterruptedException, UnsupportedEncodingException, AlipayApiException {
        as.Return_url(request);

    }

}
