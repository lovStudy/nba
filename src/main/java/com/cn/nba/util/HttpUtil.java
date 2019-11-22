package com.cn.nba.util;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    public static void httpGet(String url,Map<String,Object> map){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String param = prepareParam(map);
        System.out.println(url+ "?" + param);
        HttpGet httpget = new HttpGet(url+ "?" + param);
        httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0)");
        httpget.addHeader("Content-Type", "application/json;charset=UTF-8");

        try {
            CloseableHttpResponse response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine());
            if (entity != null) {
                // 打印响应内容
                System.out.println("Response content: " + EntityUtils.toString(entity));
            }

        }catch (Exception e){

        }


    }


    public static void httpPost(String url,Map<String,Object> map){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        try {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("t", map.get("t").toString()));
            params.add(new BasicNameValuePair("xs_app", map.get("xs_app").toString()));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            // 获取响应实体
            HttpEntity entity1 = response.getEntity();
            // 打印响应状态
            System.out.println(response.getStatusLine().getStatusCode());
            if (entity1 != null) {
                // 打印响应内容
                System.out.println("Response content: " + EntityUtils.toString(entity1));
            }

        }catch (Exception e){

        }


    }





    private static String prepareParam(Map<String, Object> paramMap) {
        StringBuffer sb = new StringBuffer();
        if (paramMap.isEmpty()) {
            return "";
        } else {
            for (String key : paramMap.keySet()) {
                String value = (String) paramMap.get(key);
                if (sb.length() < 1) {
                    sb.append(key).append("=").append(value);
                } else {
                    sb.append("&").append(key).append("=").append(value);
                }
            }
            return sb.toString();
        }
    }


}
