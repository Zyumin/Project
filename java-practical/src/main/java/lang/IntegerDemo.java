package lang;

import java.lang.reflect.Field;

/**
 * 修改了IntegerCache
 *
 * @author zhengyumin
 * @create 2019-08-13 14:47
 */
public class IntegerDemo {

    public static void main(String[] args) {
//        Integer a = new Integer(10);
//        Integer b = new Integer(10);
        Integer a = 10;
        Integer b = 10;
        method(a, b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
//        Integer c = new Integer(10);
//        System.out.println("c=" + c);


        System.out.println(Integer.MAX_VALUE);
    }


    private static void method(Integer a, Integer b) {
        changeValue(a, 100);
        changeValue(b, 200);
    }

    private static void changeValue(Integer i, int value) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(i, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
