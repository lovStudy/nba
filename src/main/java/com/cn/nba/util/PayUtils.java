package com.cn.nba.util;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class PayUtils {


    //按照ASCII码排序
    public static String createSign(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();  //所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            boolean b = v instanceof List;
            //空值不传递，不参与签名组串
            if (null != v && !"".equals(v) && !b) {
                sb.append(k + "=" + v + "&");
            }
        }
        String result = sb.toString().substring(0, sb.toString().length() - 1);
        //排序后的字符串
        //System.out.println("待签名字符串:" + result);

        return result;
    }

    public static String createSigns(Map<String, String> params, String privateKey) {
        StringBuilder sb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, String> sortParams = new TreeMap<String, String>(params);
        // 遍历排序的字典,并拼接"key=value"格式
        for (Map.Entry<String, String> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().trim();
            if (StringUtils.isNotEmpty(value))
                sb.append("&").append(key).append("=").append(value);
        }
        String stringA = sb.toString().replaceFirst("&", "");
        String stringSignTemp = stringA + privateKey;
        String signValue = MD5Util.encode(stringSignTemp).toUpperCase();
        return signValue;
    }


}
