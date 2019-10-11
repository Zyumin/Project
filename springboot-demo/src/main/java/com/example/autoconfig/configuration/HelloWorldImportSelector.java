package com.example.autoconfig.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * HelloWorld实现  {@link ImportSelector} {@link HelloWorldConfiguration}
 * @see EnableCaching 参考
 *
 * @author zhengyumin
 * @create 2019-01-04 8:03 PM
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
