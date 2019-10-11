package com.example.autoconfig.annotation;

import com.example.autoconfig.configuration.HelloWorldConfiguration;
import com.example.autoconfig.configuration.HelloWorldImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.annotation.*;

/**
 * 激活 HelloWorld 模块
 * {@link HelloWorldConfiguration}  {@link HelloWorldImportSelector}
 * @see EnableWebMvc 参考
 *
 * @author zhengyumin
 * @create 2019-01-04 7:44 PM
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}
