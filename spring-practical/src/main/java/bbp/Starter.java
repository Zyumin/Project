package bbp;

import domain.BeanClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-14 9:25 PM
 */
public class Starter {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");
////        applicationContext.refresh();
//        applicationContext.getBeanFactory().addBeanPostProcessor(new BeanPostProcessDemo());
//        applicationContext.getBeanFactory().registerSingleton("beanPostProcessDemo",new BeanPostProcessDemo());
//
//        applicationContext.getBeanFactory().registerSingleton("beanClass1",new BeanClass());
//
//        applicationContext.getBeanFactory().getBean("beanClass1");
//        System.out.println(applicationContext.getBean(BeanPostProcessDemo.class));
//        System.out.println(applicationContext.getBeanFactory().getBeanPostProcessorCount());
//
//        applicationContext.refresh();
//        System.out.println(JSON.toJSONString(applicationContext.getBeanFactoryPostProcessors()));
//        System.out.println(applicationContext.getBeanFactory().getBeanPostProcessorCount());


        BeanClass  b = applicationContext.getBean(BeanClass.class);
//        System.out.println(b.getMember());
    }
}
