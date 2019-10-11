package com.example.application;

import com.example.application.listener.BeforeConfigFileApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 应用事件引导类
 *
 * @author zhengyumin
 * @since 2019-01-11
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {
        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器
        context.addApplicationListener(event -> {
            System.err.println("监听到事件: " + event);
        });

        // 启动上下文
        context.refresh();
        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2019");

        // 关闭上下文
        context.close();
    }
}
