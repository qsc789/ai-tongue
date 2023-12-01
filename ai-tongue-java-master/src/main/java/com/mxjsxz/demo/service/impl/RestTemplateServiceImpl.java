package com.mxjsxz.demo.service.impl;

import com.mxjsxz.demo.service.IRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;

/**
 * 发送请求工具
 *
 * @author xuwenbing
 * @date 2019-05-05
 */
@Service
public class RestTemplateServiceImpl implements IRestTemplateService {

    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateServiceImpl(@Qualifier("skipSslRestTemplate") RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> T postForObject(String url, MultiValueMap<String, Object> params, Class<T> responseType) {
        return restTemplate.postForObject(url, params, responseType);
    }

    @Override
    public <T> T postForObject(String url, Map<String, String> headers
            , MultiValueMap<String, Object> params, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> header : headers.entrySet()) {
            httpHeaders.add(header.getKey(), header.getValue());
        }
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(params, httpHeaders);
        return restTemplate.postForObject(url, httpEntity, responseType);
    }


    @Override
    public FileSystemResource getFileSystemResource(File file) {
        return new FileSystemResource(file);
    }

}
