package org.lanqiao.taru.library.service;

import com.alipay.api.AlipayApiException;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

public interface AlipayService {

    public String alipayIumpSum(String userId,String[] list,String total_amount,String subject,String body) throws AlipayApiException;
    public void Notify(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;
    public void Return_url(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;
}
