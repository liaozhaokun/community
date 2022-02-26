package com.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class AlphaConfig {
    @Bean
    public SimpleDateFormat simpleDateFormat(){// bean的名字是以方法名命名的
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 该方法返回的对象将装入容器
    }
}
