package domain;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import java.beans.ConstructorProperties;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-12-05 9:41 AM
 */
public class BeanClass implements InitializingBean,BeanClassLoaderAware{
    private int member;
    public BeanClass() {
        System.out.println("init... BeanClass");
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "BeanClass{" +
                "member=" + member +
                '}';
    }

    public void init(){
        System.out.println("init method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAware:" + classLoader);
    }
}
