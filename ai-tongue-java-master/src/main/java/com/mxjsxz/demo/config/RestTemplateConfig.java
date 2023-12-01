package com.mxjsxz.demo.config;

import com.mxjsxz.demo.factory.SkipSslVerificationHttpRequestFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuwenbing
 * @date 2019-05-05
 */
@Configuration
public class RestTemplateConfig {
    @Bean("skipSslRestTemplate")
    public RestTemplate restTemplate() {
        SkipSslVerificationHttpRequestFactory skipSslVerificationHttpRequestFactory = new SkipSslVerificationHttpRequestFactory();
        return new RestTemplate(skipSslVerificationHttpRequestFactory);
    }
}