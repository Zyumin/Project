package com.example.autoconfig.annotation;

import java.lang.annotation.*;

/**
 *  “层次性” {@link FirstLevelRepository}
 * @author zhengyumin
 *
 * @create 2019-01-04 7:14 PM
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}