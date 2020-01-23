package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-14 9:25 PM
 */
public class AOPStarter {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("aop");

        Server server = (Server) applicationContext.getBean("serverImpl");
        server.doSomething();
    }
}
