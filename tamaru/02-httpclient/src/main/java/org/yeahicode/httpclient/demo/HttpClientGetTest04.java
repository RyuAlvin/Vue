package org.yeahicode.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpClientGetTest04 {

    /**
     * Get请求下载图片
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        String urlStr = "http://pic.bizhi360.com/bbpic/67/4967.jpg";
        HttpGet httpGet = new HttpGet(urlStr);
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String contentType = entity.getContentType().getValue();
            String suffix = ".jpg";
            if (contentType.contains("jpg") || contentType.contains("jpeg")) {
                suffix = ".jpg";
            } else if (contentType.contains("gif")) {
                suffix = ".gif";
            } else if (contentType.contains("bmp") || contentType.contains("bitmap")) {
                suffix = "bmp";
            } else if (contentType.contains("png")) {
                suffix = "png";
            }
            byte[] bytes = EntityUtils.toByteArray(entity);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\ryualvin\\Desktop\\abc" + suffix);
            fos.write(bytes);
            fos.close();
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
