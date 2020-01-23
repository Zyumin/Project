package bbp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-01-14 9:38 PM
 */
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.err.println("InstantiationAwareBeanPostProcessorDemo");
        return  null;
    }
}
