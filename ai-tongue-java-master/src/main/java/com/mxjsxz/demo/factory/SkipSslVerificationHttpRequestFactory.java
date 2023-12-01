package com.mxjsxz.demo.factory;


import org.springframework.http.client.SimpleClientHttpRequestFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

/**
 * restTemplate配置工厂(同时支持http和https)，参考org.springframework.boot.actuate.autoconfigure.cloudfoundry.servlet.SkipSslVerificationHttpRequestFactory
 *
 * @author xuwenbing
 * @date 2019-05-05
 */
public class SkipSslVerificationHttpRequestFactory extends SimpleClientHttpRequestFactory {
    public SkipSslVerificationHttpRequestFactory() {
    }

    @Override
    protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
        if (connection instanceof HttpsURLConnection) {
            this.prepareHttpsConnection((HttpsURLConnection) connection);
        }

        super.prepareConnection(connection, httpMethod);
    }

    private void prepareHttpsConnection(HttpsURLConnection connection) {
        connection.setHostnameVerifier(new SkipSslVerificationHttpRequestFactory.SkipHostnameVerifier());

        try {
            connection.setSSLSocketFactory(this.createSslSocketFactory());
        } catch (Exception var3) {
            ;
        }

    }

    private SSLSocketFactory createSslSocketFactory() throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init((KeyManager[]) null, new TrustManager[]{new SkipSslVerificationHttpRequestFactory.SkipX509TrustManager()}, new SecureRandom());
        return context.getSocketFactory();
    }

    private static class SkipX509TrustManager implements X509TrustManager {
        private SkipX509TrustManager() {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }
    }

    private class SkipHostnameVerifier implements HostnameVerifier {
        private SkipHostnameVerifier() {
        }

        @Override
        public boolean verify(String s, SSLSession sslSession) {
            return true;
        }
    }
}

