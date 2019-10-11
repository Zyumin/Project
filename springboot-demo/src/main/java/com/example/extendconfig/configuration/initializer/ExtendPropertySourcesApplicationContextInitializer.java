package com.example.extendconfig.configuration.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展 {@link PropertySources} {@link ApplicationContextInitializer}
 * @author zhengyumin
 * @since 2019-01-11
 */
public class ExtendPropertySourcesApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        Map<String, Object> source = new HashMap<>();
        // 1. from-ApplicationContextInitializer : 29
        // 2. from-environmentPrepared : 0
        // 3. from-ApplicationEnvironmentPreparedEvent : 9
        // 4. from-EnvironmentPostProcessor : 19
        // application.properties : 1
        // META-INF/default.properties : 7
        source.put("user.id", "29");
        MapPropertySource propertySource = new MapPropertySource("from-ApplicationContextInitializer", source);
        propertySources.addFirst(propertySource);
    }
}
