package com.mxjsxz.demo;

import com.mxjsxz.demo.properties.AiTongueProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({AiTongueProperties.class})
public class AiTongueJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiTongueJavaApplication.class, args);
    }

}
