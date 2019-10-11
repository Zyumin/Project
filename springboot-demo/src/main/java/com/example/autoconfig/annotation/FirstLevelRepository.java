package com.example.autoconfig.annotation;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * “派生性” {@link Component}
 * @author zhengyumin
 *
 * @create 2019-01-04 7:13 PM
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}
