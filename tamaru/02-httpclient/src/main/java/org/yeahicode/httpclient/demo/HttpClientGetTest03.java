package org.yeahicode.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HttpClientGetTest03 {

    /**
     * 特殊字符参数Encode
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 1、创建可关闭的http请求客户端，相当于你打开的一个浏览器
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        // 2、设置请求url
        String username = "ryualvin 123 + |";
        username = URLEncoder.encode(username, StandardCharsets.UTF_8.name());
        String password = "%^&dfdasfda 12321";
        password = URLEncoder.encode(password, StandardCharsets.UTF_8.name());
        String urlStr = String.format("http://localhost:8899/httpclient-demo/test1?username=%s&password=%s", username, password);
        // 3、构造httpGet请求对象
        HttpGet httpGet = new HttpGet(urlStr);
        /**
         * 设置请求头，
         *  用户代理：即浏览器，服务器就会认为是通过该浏览器发出的请求
         *  防盗链：必须是防止发生防盗链的网站
         */
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36");
        httpGet.setHeader("Referrer", "https://www.baidu.com");
        CloseableHttpResponse response = null;
        try {
            // 4、执行请求
            response = closeableHttpClient.execute(httpGet);
            // 5、获取响应载体
            HttpEntity entity = response.getEntity();
            /**
             * 获取相应头 start
             */
            // 获取相应内容中的状态行
            StatusLine statusLine = response.getStatusLine();
            // 获取状态行中的响应码
            int statusCode = statusLine.getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // 如果请求成功
                System.out.println("=============================================================");
                Arrays.stream(response.getAllHeaders()).forEach(x -> System.out.println(String.format("%s=%s", x.getName(), x.getValue())));
                System.out.println("=============================================================");
                System.out.println(String.format("从entity也可以获取响应头的一些内容：%s", entity.getContentType()));
                String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
                System.out.println(result);
            } else {
                // 如果请求失败
            }
            /**
             * 获取响应头 end
             */
            // 6、确保响应载体中的输入流关闭
            EntityUtils.consume(entity);
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
