package org.example;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class ClientService {
    public static final String PATH =
            "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    private ClientService() {
    }

    public static CloseableHttpResponse getServerResponse() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().
                setDefaultRequestConfig(RequestConfig.custom().
                        setConnectTimeout(5000).
                        setSocketTimeout(30000).
                        setRedirectsEnabled(false).
                        build()).
                build();

        // создание объекта запроса с произвольными заголовками
        HttpGet request = new HttpGet(PATH);
        request.setHeader(HttpHeaders.ACCEPT, org.apache.http.entity.ContentType.APPLICATION_JSON.getMimeType());

        // отправка запроса
        return httpClient.execute(request);
    }
}
