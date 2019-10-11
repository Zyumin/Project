package com.example.autoconfig.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java系统属性 条件判断 {@link OnSystemPropertyCondition}
 *
 * @see ConditionalOnClass 参考
 *
 * @author zhengyumin
 * @create 2019-01-04 8:31 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty  {
    /**
     * Java 系统属性名称
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     * @return
     */
    String value();

}
