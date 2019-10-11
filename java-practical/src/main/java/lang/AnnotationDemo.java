package lang;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-08-07 09:36
 */
@Deprecated
public class AnnotationDemo {
    public static void main(String[] args) {

        Annotation a = AnnotationDemo.class.getAnnotations()[0];

        System.out.println(a);

        Class c = a.annotationType();

        System.out.println(c.toString());

        Arrays.asList(c.getMethods()).stream().forEach((Consumer) o -> System.out.println(o));
    }
}
