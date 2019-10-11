package com.example.autoconfig.bootstarp;

import com.example.autoconfig.annotation.FirstLevelRepository;
import com.example.autoconfig.annotation.SecondLevelRepository;
import com.example.autoconfig.repository.MyFirstLevelRepository;
import com.example.autoconfig.repository.MySecondLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 注解派生性 引导类
 * {@link FirstLevelRepository} {@link SecondLevelRepository}
 *
 * @author zhengyumin
 * @create 2019-01-04 7:23 PM
 */
@ComponentScan(basePackages = "com.example.autoconfig.repository")
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // myFirstLevelRepository Bean 是否存在
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository",MyFirstLevelRepository.class);

        System.err.println("myFirstLevelRepository Bean : "+myFirstLevelRepository);

        // myFirstLevelRepository Bean 是否存在
        MySecondLevelRepository mySecondLevelRepository =
                context.getBean("mySecondLevelRepository",MySecondLevelRepository.class);

        System.err.println("mySecondLevelRepository Bean : "+mySecondLevelRepository);

        // 关闭上下文
        context.close();
    }
}
