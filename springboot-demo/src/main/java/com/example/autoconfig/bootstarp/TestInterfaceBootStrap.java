package com.example.autoconfig.bootstarp;

import com.example.autoconfig.instances.TestInterface;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.autoconfig.instances.TestInterfaceConfig;

/**
 * 多实例bean注入 {@link TestInterfaceConfig}
 *
 * @author zhengyumin
 * @create 2019-01-09 10:49 AM
 */
@SpringBootApplication(scanBasePackages = "com.example.autoconfig.instances")
public class TestInterfaceBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(TestInterfaceBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        TestInterface firstInterface = context.getBean("firstInterface", TestInterface.class);

        TestInterface secondInterface = context.getBean("secondInterface", TestInterface.class);


        System.err.println("firstInterface name : " + firstInterface.getName());

        System.err.println("secondInterface name : " + secondInterface.getName());

        // 关闭上下文
        context.close();
    }
}
