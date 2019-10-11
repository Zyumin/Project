package com.example.autoconfig.bootstarp;

import com.example.autoconfig.annotation.EnableHelloWorld;
import com.example.autoconfig.configuration.HelloWorldConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @Enable 模块化,需要手动开启
 * {@link EnableHelloWorld} {@link HelloWorldConfiguration}
 *
 * @author zhengyumin
 * @create 2019-01-04 7:48 PM
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld =  context.getBean("helloWorld", String.class);

        System.err.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
