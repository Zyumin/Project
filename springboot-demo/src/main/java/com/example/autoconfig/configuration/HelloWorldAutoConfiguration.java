package com.example.autoconfig.configuration;


import com.example.autoconfig.annotation.EnableHelloWorld;
import com.example.autoconfig.condition.ConditionalOnSystemProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

/**
 * HelloWorld配置 装载了bean
 *
 * @see EnableAutoConfiguration
 * @see WebMvcAutoConfiguration
 *
 * @author zhengyumin
 * @create 2019-01-04 8:45 PM
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "zhengyumin") // 条件装配
public class HelloWorldAutoConfiguration {

}
