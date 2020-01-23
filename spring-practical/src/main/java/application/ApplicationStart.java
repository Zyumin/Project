package application;

import domain.BeanClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-10 5:52 PM
 */
public class ApplicationStart {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");
//        applicationContext.refresh();


        System.out.println("before_get_bean");
        BeanClass beanClass = applicationContext.getBean(BeanClass.class);

        System.out.println(beanClass.toString());
    }
}
