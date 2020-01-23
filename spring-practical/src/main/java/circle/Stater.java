package circle;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengyumin
 * @description 循环依赖解决问题
 * @date 2019-11-30 4:37 PM
 */
@ComponentScan(value="circle")
@Configuration
public class Stater {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Stater.class);
//        applicationContext.scan("circle");
//        applicationContext.refresh();
//        applicationContext.start();

//        applicationContext.getBean(DemoA.class);


    }

}
