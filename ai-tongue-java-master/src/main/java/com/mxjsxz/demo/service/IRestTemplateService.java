package com.mxjsxz.demo.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.util.Map;

/**
 * 发送请求工具
 *
 * @author xuwenbing
 * @date 2019-05-05
 */
public interface IRestTemplateService {
    /**
     * 发送post请求
     *
     * @param url          请求地址
     * @param params       请求参数
     * @param responseType 返回值类型
     * @param <T>
     * @return
     */
    <T> T postForObject(String url, MultiValueMap<String, Object> params, Class<T> responseType);

    /**
     * 发送post请求
     *
     * @param url          请求地址
     * @param headers      请求头
     * @param params       请求参数
     * @param responseType 返回值类型
     * @param <T>
     * @return
     */
    <T> T postForObject(String url, Map<String, String> headers
            , MultiValueMap<String, Object> params, Class<T> responseType);


    /**
     * 返回文件资源对象：使用params.put("file",fileSystemResource)
     *
     * @param file
     * @return
     */
    FileSystemResource getFileSystemResource(File file);
}
