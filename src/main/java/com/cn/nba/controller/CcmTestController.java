package com.cn.nba.controller;

import com.cn.nba.pay.MyWxPayConfig;
import com.cn.nba.util.PayUtils;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class CcmTestController {
    Logger logger = LoggerFactory.getLogger(CcmTestController.class);

    @Autowired
    private MyWxPayConfig myWxPayConfig;

    @GetMapping("/test")
    public void test() {
        WXPay wxPay = new WXPay(myWxPayConfig);
        Map<String, String> reqData = new HashMap<>();
        reqData.put("appid", "wx5f358dc02851e775");
        reqData.put("mch_id", "1515160991");
        reqData.put("nonce_str", RandomStringUtils.randomAlphanumeric(10));
        reqData.put("body", "酒店");
        reqData.put("out_trade_no", String.valueOf(RandomStringUtils.randomAlphanumeric(10)));
        reqData.put("fee_type", "CNY");
        reqData.put("total_fee", "1");
        reqData.put("spbill_create_ip", "127.0.0.1");
        reqData.put("notify_url", "www.baidu.com");
        reqData.put("trade_type", "JSAPI");
        reqData.put("openid", "o2BB20kPoapS7UqSavrPDAn3xAAM");
        //   String signTypes = PayUtils.createSigns(reqData,"pkbqn2ndffk00bnnltghdxntiqfsmwmk");
        //   reqData.put("sign", signTypes);
        Map<String, String> response = null;
        try {
            response = wxPay.unifiedOrder(reqData, 6000, 8000);// 微信sdk集成方法, 统一下单接口unifiedOrder, 此处请求   MD5加密   加密方式
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("微信支付下单成功, 返回值 response={}", response);
        String returnCode = response.get("return_code");
        String prepay_id = response.get("prepay_id");


    }


}
