package com.practical;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-11 15:26
 */
public class ApplicationContextDemo {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();



        applicationContext.addApplicationListener(new MessageListener());

        applicationContext.refresh();
        applicationContext.publishEvent(new MessageEvent("hello"));

        applicationContext.publishEvent(new MessageEvent("hi"));

        System.out.println(Thread.currentThread().getName());

        applicationContext.stop();

    }

    public  static class MessageEvent extends ApplicationEvent {
        public MessageEvent(Object source) {
            super(source);
        }
    }



    public static class MessageListener implements ApplicationListener {

        @Override
        public void onApplicationEvent(ApplicationEvent event) {
//            if(event instanceof MessageEvent){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("current thread name:"+Thread.currentThread().getName()+"\tevent:"+event.getSource());

//            }

        }
    }



}
