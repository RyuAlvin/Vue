package org.yeahicode.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class HttpClientGetTest06 {

    /**
     * 连接超时，socket超时，从连接池里获取连接的的超时时间
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "https://www.baidu.com/";

        HttpGet httpGet = new HttpGet(urlStr);
        // 创建一个代理
        HttpHost host = new HttpHost("120.237.144.200", 9091);
        // 对每一个请求进行定制化的配置，会覆盖全局的默认请求配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setProxy(host)
                // 设置连接服务器超时时间
                .setConnectTimeout(3000)
                // 设置从服务器获取相应数据的时间间隔。数据不是一次传输，而是分多次传输，每次传输的时间间隔超时设置
                .setSocketTimeout(5000)
                // 从连接池中获取连接的超时时间
                .setConnectionRequestTimeout(5000)
                .build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            System.out.println(result);
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
