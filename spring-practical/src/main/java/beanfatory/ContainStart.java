package beanfatory;

import com.alibaba.fastjson.JSON;
import domain.BeanClass;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

/**
 * @author zhengyumin
 * @description BeanFactory容器类
 * @date 2019-12-04 8:04 PM
 */
public class ContainStart {

    public  static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("application.xml"));
//        xmlBeanFactory.preInstantiateSingletons();
//        xmlBeanFactory.addBeanPostProcessor();


        List<BeanPostProcessor> list =  xmlBeanFactory.getBeanPostProcessors();
        String []beanDefinitionNames = xmlBeanFactory.getBeanDefinitionNames();

//        List<BeanPostProcessor> list =  xmlBeanFactory.();


        System.out.println("beanDefinitionNames,list:"+ JSON.toJSONString(beanDefinitionNames));
        System.out.println("before get,list:"+list.size());

        xmlBeanFactory.getBean(BeanClass.class);
        BeanDefinition beanDefinition = xmlBeanFactory.getBeanDefinition("beanClass");

        list =  xmlBeanFactory.getBeanPostProcessors();
        System.out.println("beanDefinitionNames,list:"+ JSON.toJSONString(beanDefinitionNames));
        System.out.println("after get,list:"+list.size());

        System.out.println(beanDefinition.toString());
//        synchronized(beanDefinition){
//            try {
//                beanDefinition.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        //加载方式
    }
}
