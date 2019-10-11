package lang.reflect;

import lang.object.ObjectLayoutDemo;

import java.lang.reflect.Field;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-15 11:52
 */
public class ReflectDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        ObjectLayoutDemo.A a = new ObjectLayoutDemo.A();
        Class clazz = a.getClass();
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("{");
        for (Field f : fields) {
            Field ageField = clazz.getDeclaredField(f.getName());
            ageField.setAccessible(true);
            System.out.println("\"" + f.getName() + "\"" + ":" + ageField.get(a));
        }
        System.out.println("}");
    }
}
