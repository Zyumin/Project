package bbp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author zhengyumin
 * @description 回调
 * @date 2020-01-14 9:23 PM
 */
public class BeanPostProcessDemo implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.err.println("in BeanPostProcessDemo#postProcessBeforeInitialization");
        System.out.println("init bean...."+beanName);

        return bean;
    }

}
