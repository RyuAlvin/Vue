package org.yeahicode.httpclient.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class HttpClientGetTest09 {

    /**
     * 发送multipart/form-data类型上传文件的post请求
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "http://localhost:8899/httpclient-demo/testUpload";

        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost(urlStr);
        // 构造一个ContentBody的实现类对象
        // 构造上传文件使用的Entity
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setCharset(Consts.UTF_8);//设置编码
        builder.setContentType(ContentType.create("multipart/form-data", Consts.UTF_8));
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//设置浏览器模式
        // 对于普通的表单字段如果含有中文的话，不能通过addTextBody，否则乱码
        StringBody usernameTextBody = new StringBody("小明", ContentType.create("text/plain", Consts.UTF_8));
        FileBody fileBody = new FileBody(new File("C:\\Users\\ryualvin\\Desktop\\test.log"));
        HttpEntity httpEntity = builder
                .addPart("file", fileBody)
                // 通过file，byte[]，inputstream来上传文件
                .addBinaryBody("file", new File("C:\\Users\\ryualvin\\Desktop\\test.png"))
                // .addTextBody("username", "小明") // 普通的表单字段如果含有中文的话，不能通过addTextBody，否则乱码
                .addPart("username", usernameTextBody)
                .addTextBody("password", "1332|  ^7%$* -")
                .build();
        httpPost.setEntity(httpEntity);
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
