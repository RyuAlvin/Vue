package org.yeahicode.httpclient.demo;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HttpClientGetTest07 {

    /**
     * 发送application/x-www-form-urlencoded类型的请求，即表单请求
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "http://localhost:8899/httpclient-demo/test2";

        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost(urlStr);
        /**
         * 给post对象设置参数
         *  NameValuePair：
         *      <input id="user-name-label" type="text" name="username">
         *      <input id="password-label" type="text" name="password">
         *              标签里的name和输入的值就构成了一个NameValuePair
         */
        List<NameValuePair> list = new ArrayList<>();
        BasicNameValuePair username = new BasicNameValuePair("username", "ryualvin");
        BasicNameValuePair password = new BasicNameValuePair("password", "32435&| fdaf");
        list.add(username);
        list.add(password);
        // 设置请求Entity
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Consts.UTF_8);
        // 即使不设置默认也是"application/x-www-form-urlencoded"
        entity.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
        httpPost.setEntity(entity);
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
