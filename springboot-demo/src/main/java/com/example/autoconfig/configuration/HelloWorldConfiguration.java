package com.example.autoconfig.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * HelloWorld配置 装载了bean
 *
 * @author zhengyumin
 * @create 2019-01-04 7:45 PM
 */

public class HelloWorldConfiguration {

    /**
     * bean name 默认是helloWold
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World 2019";
    }


}
