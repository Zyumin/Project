package com.example.autoconfig.instances;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类 {@link DefaultTestInterface}
 *
 * @author zhengyumin
 * @create 2019-01-09 10:34 AM
 */
@Configuration
@PropertySource("classpath:/META-INF/test.interface.properties")
public class TestInterfaceConfig {


    @Bean(name = "firstInterface")
    @ConfigurationProperties(prefix="spring.test.interface.first")
    public TestInterface firstInterface(){
        return new DefaultTestInterface();
    }

    @Bean(name = "secondInterface")
    @ConfigurationProperties(prefix="spring.test.interface.second")
    public TestInterface secondInterface(){
        return new DefaultTestInterface();
    }
}
