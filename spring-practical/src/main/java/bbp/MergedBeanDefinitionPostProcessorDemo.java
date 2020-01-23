package bbp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author zhengyumin
 * @description 修改beanDefinition
 * @date 2020-01-14 9:59 PM
 */
public class MergedBeanDefinitionPostProcessorDemo implements MergedBeanDefinitionPostProcessor {

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {

        System.err.println("in MergedBeanDefinitionPostProcessorDemo#postProcessMergedBeanDefinition");
//        MutablePropertyValues propertyValues= new MutablePropertyValues();
//        propertyValues.add("member",1);
//        beanDefinition.setPropertyValues(propertyValues);
        System.out.println(beanDefinition.toString());
        beanDefinition.setLazyInit(true);
        System.out.println(beanDefinition.toString());
    }

    @Override
    public void resetBeanDefinition(String beanName) {

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
