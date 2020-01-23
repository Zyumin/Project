package beanDefinition;

import domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-12 10:15 PM
 */
public class BeanDefinitionBuilderDemo {
    public static void main(String[] args) {

        //1. 通过BeanDefinitionBuilder
        BeanDefinition beanDefinition =
                BeanDefinitionBuilder.genericBeanDefinition(User.class)
                .addPropertyValue("name","小与米")
                .addPropertyValue("age",26)
                .getBeanDefinition();

        System.out.println(beanDefinition);

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory ();
        beanFactory.registerBeanDefinition("user",beanDefinition);
        System.out.println(beanFactory.getBean(User.class));

        //2.通过AbstractBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        genericBeanDefinition.setPropertyValues(new MutablePropertyValues().add("name","小与米").add("age",26));

        System.out.println(genericBeanDefinition);
    }
}
