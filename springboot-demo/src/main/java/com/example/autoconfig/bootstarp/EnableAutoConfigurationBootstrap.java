package com.example.autoconfig.bootstarp;

import com.example.autoconfig.configuration.HelloWorldAutoConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link HelloWorldAutoConfiguration}
 *
 * @author zhengyumin
 * @create 2019-01-04 8:45 PM
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {
    public static void main(String[] args) {

        //-Ddebug
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);

        System.err.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();

    }
}
