package org.yeahicode.httpclient.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class HttpClientGetTest01 {
    public static void main(String[] args) throws IOException {
        // 1、定义请求url
        String urlStr = "https://www.baidu.com";
        // 2、创建URL实例
        URL url = new URL(urlStr);
        // 3、通过URL实例创建一个连接
        URLConnection urlConnection = url.openConnection();
        // 4、转换成HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) urlConnection;

        /**
         * 请求行
         * 空格
         * 请求头
         * 请求体
         */
        // 4.1、设置请求方式
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept-Charset", "utf-8");

        try (
                // 5、通过连接获取输入流
                InputStream is = urlConnection.getInputStream();
                // 6、输入流转换成字符流
                InputStreamReader ir = new InputStreamReader(is, StandardCharsets.UTF_8);
                // 7、字符流转换成缓冲流
                BufferedReader br = new BufferedReader(ir)
        ) {
            // 8、逐行读取并打印
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        // 6、逐行读取字符流并打印
    }
}
