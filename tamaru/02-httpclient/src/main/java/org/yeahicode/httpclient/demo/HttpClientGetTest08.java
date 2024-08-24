package org.yeahicode.httpclient.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpClientGetTest08 {

    /**
     * 发送application/json类型的请求
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "http://localhost:8899/httpclient-demo/testJson";

        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost(urlStr);
        // 设置请求Entity
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "ryualvinjsonobj");
        jsonObject.put("password", "12312|78^&* -%$");
        StringEntity jsonEntity = new StringEntity(jsonObject.toString());
        // 设置内容类型
        jsonEntity.setContentType(new BasicHeader("content-type", "application/json;charset=utf-8"));
        // 设置编码，否则有中文的话可能会乱码
        jsonEntity.setContentEncoding(Consts.UTF_8.name());
        httpPost.setEntity(jsonEntity);
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpPost);
            HttpEntity responseEntity = response.getEntity();
            String result = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            System.out.println(result);
            EntityUtils.consume(responseEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (closeableHttpClient != null) {
                try {
                    closeableHttpClient.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
