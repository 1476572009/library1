package org.lanqiao.taru.library.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.lanqiao.taru.library.config.AlipayConfig;
import org.lanqiao.taru.library.dao.BookDao;
import org.lanqiao.taru.library.dao.BookcarDao;
import org.lanqiao.taru.library.dao.BorrowDao;
import org.lanqiao.taru.library.dao.OrderDao;
import org.lanqiao.taru.library.model.Book;
import org.lanqiao.taru.library.model.Bookcar;
import org.lanqiao.taru.library.model.Borrow;
import org.lanqiao.taru.library.model.Order;
import org.lanqiao.taru.library.service.AlipayService;
import org.lanqiao.taru.library.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    OrderDao od;
    @Autowired
    BookcarDao bd;
    @Autowired
    BorrowDao bod;
    @Autowired
    BookDao bookDao;

    @Transactional
    @Override
    public String alipayIumpSum(String userId,String[] list,String total_amount,String subject,String body) throws AlipayApiException {
        Order o=new Order();
        String out_trade_no= IdUtil.getDateId();
        o.setOrderId(out_trade_no);
        o.setOrderUserId(userId);
        o.setOrderTotalPrice(total_amount);
        o.setOrderComment(body);
        for(String carId:list){
            Bookcar bookcar=bd.queryBookcar(carId);
            Borrow b=new Borrow();
            b.setBorrowId(bookcar.getBookcarId());
            b.setBorrowUserId(userId);
            b.setBorrowBookId(bookcar.getBookcarBookId());
            b.setBorrowTime(bookcar.getBookcarBorrowTime());
            b.setBorrowRemaintime(bookcar.getBookcarBorrowTime());
            Book book=bookDao.queryDetail(bookcar.getBookcarBookId());
            System.out.println(Integer.valueOf(book.getBookPrice()));
            System.out.println(Integer.valueOf(bookcar.getBookcarBorrowTime()));
            System.out.println(String.valueOf(Integer.valueOf(book.getBookPrice())*Integer.valueOf(bookcar.getBookcarBorrowTime())));
            b.setBorrowBookTotalPrice(String.valueOf(Integer.valueOf(book.getBookPrice())*Integer.valueOf(bookcar.getBookcarBorrowTime())));
            b.setBorrowOrderId(o.getOrderId());
            bod.insert(b);
        }
        bd.delBookcars(list);
        od.add(o);


        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
  //      AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();//创建API对应的request类


        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
   //     AlipayTradeQueryResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
    //    System.out.print(response.getBody());

        return result;
    }

       @Override
    public void Notify(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            }else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序

                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }



        }else {//验证失败


            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }

    @Override
    public void Return_url(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        System.out.println("bool"+signVerified);
        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            Order o=new Order();
            o.setOrderId(out_trade_no);
            System.out.println("orderId"+o.getOrderId());
            od.update(o);

        }else {

        }

    }
}
