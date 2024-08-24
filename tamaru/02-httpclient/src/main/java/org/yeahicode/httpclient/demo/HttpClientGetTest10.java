package org.yeahicode.httpclient.demo;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class HttpClientGetTest10 {

    /**
     * 测试https：配置httpclient绕过https安全认证
     *
     * 请求https连接，分为安全和不安全。
     * https证书是收费的，要是过期的话就是不安全的。还有自签名的证书，也是不安全的。
     *
     * 针对不安全的https连接，可通过下列两个方式访问：
     *  1、通过认证需要的密钥配置httpclient
     *  2、配置httpclient绕过https安全认证
     *
     * @param args
     * @throws UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        org.apache.http.config.Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", trustHttpsCertificates())
                .build();

        // 创建一个ConnectionManager
        PoolingHttpClientConnectionManager pool = new PoolingHttpClientConnectionManager(registry);
        // 定制CloseableHttpClient对象
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setConnectionManager(pool);
        // 配置好httpClient之后，通过build方法来获取httpClient对象
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        String urlStr = "https://localhost:8888/httpsTest2";
        HttpGet httpGet = new HttpGet(urlStr);
        CloseableHttpResponse response = null;
        try {
            response = closeableHttpClient.execute(httpGet);
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

    // 创建支持安全协议的连接工厂
    private static ConnectionSocketFactory trustHttpsCertificates() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContextBuilder sslContextBuilder = new SSLContextBuilder();
        sslContextBuilder.loadTrustMaterial(null, new TrustStrategy() {
            // 判断是否信任url
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        });
        SSLContext sslContext = sslContextBuilder.build();

        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext,
                new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}
                , null, NoopHostnameVerifier.INSTANCE);

        return sslConnectionSocketFactory;
    }
}
