package com.example.application.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 * After HelloWorld {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 *
 * @author zhengyumin
 * @since 2019-01-11
 */
public class AfterHelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent>,Ordered {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.err.println("AfterHelloWorld : " + event.getApplicationContext().getId()
                + " , timestamp : " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
