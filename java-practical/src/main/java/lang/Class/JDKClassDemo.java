package lang.Class;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-09-01 15:45
 */
public class JDKClassDemo {

    public static void main(String[] args) throws NoSuchFieldException {

        Class c = ClassDemo.class;

        System.err.println("getDeclaredFields");
        for(Field f : c.getFields()){
            System.out.println(f.toString());
        }

        System.err.println("getMethods");
        for(Method f : c.getDeclaredMethods()){
            System.out.println(f.toString());

        }

        System.err.println(c.getTypeName());

        System.err.println("getAnnotatedInterfaces");
        for(AnnotatedType f :  c.getAnnotatedInterfaces()){
            System.out.println(f.getType());
        }

        System.err.println("getDeclaredAnnotations");
        for(Annotation f :  c.getDeclaredAnnotations()){
            System.out.println(f.toString());
        }

        System.err.println("getAnnotations");
        for(Annotation f :  c.getAnnotations()){
            System.out.println(f.toString());
        }





    }
}
